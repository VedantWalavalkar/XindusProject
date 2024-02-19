Backend Intern Technical Assessment:

The application is based on e-commerce solution, it allows user to create and manage their product wishlists.

Description:
• Created a Spring Boot application, using MySQL as the database.
• Implement Object Relation Mapping using JPA, to access the database.
• Implemented authentication and authorisation using Spring Security.
• The project comprises of three main APIs that are used to create or add items to wishlists, view existing wishlists, and remove items from the wishlists.
• Other APIs like adding product are created to test the major APIs.
• Unit testing was implemented by junit.


Installation: 
• To start the installation, firstly clone the project from the github repository.
• The project runs on spring boot version 3.2.2.
• Once the clone is completed, run the code.
• Other things to install are Postman and the Postman API Collection, download the XindusAPIs.postman_collection  and import it in the postman.
• If postman is not available, the project consists of swagger dependency. But to check api on swagger do disable the spring security. "http://localhost:8080/swagger-ui/index.html" use this link to test api on swagger.
• Before testing apis do add some products using the add product apis, as the functions managing wishlist will require some products.
