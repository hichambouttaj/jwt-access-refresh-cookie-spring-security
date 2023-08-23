# jwt-access-refresh-cookie-spring-security
This project demonstrates the implementation of security using Spring Boot 3.0 and JSON Web Tokens (JWT). It includes the following features:

## Diagram

![dc](https://github.com/hichambouttaj/jwt-access-refresh-cookie-spring-security/assets/57833129/9f364b54-bf95-452e-9239-ee3929d46aec)

## Features
* User login with JWT authentication
* Role with permissions for authorization
* Customized access denied handling
* Logout mechanism
* Refresh token
* Send token using HttpOnly Cookie

## Technologies
* Spring Boot 3.0
* Spring Security
* JSON Web Tokens (JWT)
* Maven
* MySQL
 
## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

* JDK 17+
* Maven 3+


To build and run the project, follow these steps:

* Clone the repository: `git clone https://github.com/hichambouttaj/jwt-access-refresh-cookie-spring-security.git`
* Navigate to the project directory: cd jwt-access-refresh-cookie-spring-security
* Add database "jwt_cookie" to mysql
* Build the project: mvn clean install
* Run the project: mvn spring-boot:run 

-> The application will be available at http://localhost:8080.
