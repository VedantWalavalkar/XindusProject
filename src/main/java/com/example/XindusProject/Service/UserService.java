package com.example.XindusProject.Service;

import com.example.XindusProject.DTO.Request.AddUserRequest;
import com.example.XindusProject.DTO.Response.ProductResponse;
import com.example.XindusProject.Modal.Product;
import com.example.XindusProject.Modal.User;
import com.example.XindusProject.Modal.Wishlist;
import com.example.XindusProject.Repositories.ProductRepository;
import com.example.XindusProject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.XindusProject.Transformers.UserTransformer.addUserRequestToUser;

@Service
public class UserService {

    // INJECTING BEAN OF PRODUCT REPOSITORY
    @Autowired
    ProductRepository productRepository;

    // INJECTING BEAN OF USER REPOSITORY
    @Autowired
    UserRepository userRepository;

    public User addUser(AddUserRequest addUserRequest){
        // USING A TRANSFORMER CLASS ( addUserRequestToUser ) TO SIMPLIFY THE CODE.
        User user = addUserRequestToUser(addUserRequest);
        Wishlist wishlist = new Wishlist(); // CREATING A WISHLIST FOR THE USER.
        // SETTING THE OTHER REQUIRED FIELDS.
        wishlist.setUser(user);
        wishlist.setProducts(new ArrayList<>()); // SETTING IT AS EMPTY ARRAYLIST, AS IT IS NEW USER.
        user.setWishlist(wishlist);
        userRepository.save(user); // SAVING THE USER INTO THE DATABASE.
        return user; // DID NOT NEED TO RETURN THE USER, BUT WAS REQUIRED IN TESTING PURPOSE.
    }

    public List<ProductResponse> getProductlist(int id) {
        Optional<User> optionalUser = userRepository.findById(id); // USING OPTIONAL AS THE FIND BY ID METHOD RETURNS OPTIONAL OBJECT.
        User user = optionalUser.get();
        if(user == null) throw new RuntimeException("No User Found"); // THROWS EXCEPTION IF THE USER IS NOT FOUND.
        Wishlist wishlist = user.getWishlist();
        List<Product> list = wishlist.getProducts();
        List<ProductResponse> newList = new ArrayList<>();
        for(Product product : list){
            // ITERATING OVER THE LIST, AND ADDING IT AS A PRODUCT RESPONSE TO SEND ONLY REQUIRED DATA.
            ProductResponse productResponse = ProductResponse.builder()
                    .productName(product.getProductName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .build();

            newList.add(productResponse);
        }
        return newList;
    }

    public void addToWishlist(int prodId, int userId) {
        Optional<Product> optionalProduct = productRepository.findById(prodId);
        Optional<User> optionalUser = userRepository.findById(userId);

        User user = optionalUser.get();
        Product product = optionalProduct.get();

        if(product == null) throw new RuntimeException("Product does not exist");
        if(user == null) throw new RuntimeException("User does not exist");

        Wishlist wishlist = user.getWishlist();
        List<Product> products = wishlist.getProducts();
        products.add(product);

        List<Wishlist> wishlists = product.getWishlist();
        wishlists.add(wishlist);


        wishlist.setProducts(products);
        user.setWishlist(wishlist);
        product.setWishlist(wishlists);

        User savedUser = userRepository.save(user);
        Product savedProduct = productRepository.save(product);
    }

    public void removeFromWishlist(int prodId, int userId) {
        Optional<Product> optionalProduct = productRepository.findById(prodId);
        Optional<User> optionalUser = userRepository.findById(userId);

        User user = optionalUser.get();
        Product product = optionalProduct.get();

        if(product == null) throw new RuntimeException("Product does not exist");
        if(user == null) throw new RuntimeException("User does not exist");


        Wishlist wishlist = user.getWishlist();
        List<Product> productList = wishlist.getProducts();
        for(int i = 0; i<productList.size() ; i++){
            if(productList.get(i) != product) continue;
            productList.remove(i);
            break;
        }
        wishlist.setProducts(productList);


        List<Wishlist> wishlistList = product.getWishlist();
        for(int i = 0; i< wishlistList.size() ; i++){
            if(wishlistList.get(i) != wishlist) continue;
            wishlistList.remove(i);
            break;
        }
        product.setWishlist(wishlistList);

        Product savedProduct = productRepository.save(product);
        User savedUser = userRepository.save(user);
    }
}
