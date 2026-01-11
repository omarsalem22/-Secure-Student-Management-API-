# Student Management System API

A RESTful API built with Spring Boot for managing student records with JWT-based authentication and role-based access control.


## Technologies Used

- Java 11+
- Spring Boot 2.7.x
- Spring Security with JWT
- Spring Data JPA
- H2 In-Memory Database
- Maven/Gradle
- JUnit 5 for testing

## Prerequisites

- java

- Postman

## Setup Instructions

1. **Clone the repository**

   git clone <https://github.com/omarsalem22/-Secure-Student-Management-API->


2. **Build the project**

  
   mvn clean install





## Running the Application



mvn spring-boot:run



The application will start on `http://localhost:8080`

## Authentication

This API uses JWT (JSON Web Token) for stateless authentication.

### Default Users


### Obtaining JWT Token

**Endpoint:** `POST /api/auth/login`



## API Documentation

### Base URL
```
http://localhost:8080/api
```

### Authentication Endpoints

#### Login
- **URL:** `/api/auth/login`
- **Method:** `POST`
- **Auth Required:** No
- **Request Body:**
  ```json
  {
    "username": "admin",
    "password": "admin123"
  }

## Testing

### Running Unit Tests


mvn test





## Database

### H2 Console

The H2 database console is available at: `http://localhost:8080/h2-console`

**Connection Settings:**
- JDBC URL: `jdbc:h2:mem:test`
- Username: `sa`
- Password:''



## Role-Based Access Control

| Endpoint | ADMIN | USER |
|----------|-------|------|
| POST /api/students | ✅ | ❌ |
| GET /api/students | ✅ | ✅ |
| GET /api/students/{id} | ✅ | ✅ |
| PUT /api/students/{id} | ✅ | ❌ |
| DELETE /api/students/{id} | ✅ | ❌ |

## Configuration



# Database Configuration
spring.datasource.url=jdbc:h2:mem:test
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JWT Configuration
jwt.secret=CFlrMMoGpaR8qKtYTLvrHoRRhO583ZZwhrbr4gB7Bds >> must be in env file
jwt.expiration=36000000

