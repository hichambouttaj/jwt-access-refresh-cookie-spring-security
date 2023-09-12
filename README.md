# JWT Access & Refresh Cookie with Spring Security

This project demonstrates the implementation of security using Spring Boot 3.0 and JSON Web Tokens (JWT). It provides a robust authentication and authorization system with features like JWT-based login, role-based permissions, access denial handling, logout, and refresh token support. Additionally, it securely sends tokens using HttpOnly cookies.

## Diagram

![Architecture Diagram](https://github.com/hichambouttaj/jwt-access-refresh-cookie-spring-security/assets/57833129/9f364b54-bf95-452e-9239-ee3929d46aec)

## Features

- **User Login with JWT Authentication**: Secure user authentication using JSON Web Tokens.
- **Role-Based Authorization**: Assign roles with fine-grained permissions for access control.
- **Customized Access Denied Handling**: Handle unauthorized access gracefully.
- **Logout Mechanism**: Provide users with a secure way to log out.
- **Refresh Token**: Implement token refreshing for long-lived sessions.
- **Secure Token Delivery**: Tokens are securely delivered using HttpOnly cookies.

## Technologies

- [Spring Boot 3.0](https://spring.io/projects/spring-boot): The foundation of the application.
- [Spring Security](https://spring.io/projects/spring-security): For robust security features.
- [JSON Web Tokens (JWT)](https://jwt.io/): Used for secure authentication and authorization.
- [Maven](https://maven.apache.org/): For project management and dependency handling.
- [MySQL](https://www.mysql.com/): As the database backend.
 
## Getting Started

To get started with this project, ensure that you have the following prerequisites installed on your local machine:

- **JDK 17+**: Install the latest Java Development Kit.
- **Maven 3+**: Install the latest version of Maven for dependency management.

Follow these steps to build and run the project:

1. Clone the repository:

```bash
 git clone https://github.com/hichambouttaj/jwt-access-refresh-cookie-spring-security.git
```

2. Navigate to the project directory:
   
```bash
 cd jwt-access-refresh-cookie-spring-security
```

3. Create a MySQL database named "jwt_cookie."
4. Build the project:

```bash
 mvn clean install
```

5. Run the project:

```bash
 mvn spring-boot:run
```

The application will be available at http://localhost:8080.

Feel free to explore the code, customize it to your needs, and use it as a reference for implementing secure authentication and authorization in your own Spring Boot projects.
