package com.example.XindusProject.Config;

import com.example.XindusProject.Modal.User;
import com.example.XindusProject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserInfoUserServiceDetails implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if(user == null)
            throw new RuntimeException("User Not Found");

        return new UserDetailsCreator(user);
    }

//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByName(username);
//        if(user == null)
//            throw new RuntimeException("User Not Found");
//
//        return new UserDetailsCreator(user);
//    }
}
