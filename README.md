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

### Student Endpoints

All student endpoints require authentication. Include the JWT token in the Authorization header.

#### Create Student
- **URL:** `/api/students`
- **Method:** `POST`
- **Auth Required:** Yes
- **Permissions:** ADMIN only
- **Request Body:**
  ```json
  {
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "dateOfBirth": "2000-01-15"
  }
  ```
- **Success Response:** `201 Created`
  ```json
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "dateOfBirth": "2000-01-15"
  }
  ```
- **Error Responses:**
  - `400 Bad Request` - Validation errors
    ```json
    {
      "timestamp": "2026-01-11T10:30:00",
      "status": 400,
      "errors": {
        "email": "Invalid email format",
        "firstName": "First name is required"
      }
    }
    ```
  - `403 Forbidden` - Insufficient permissions
  - `401 Unauthorized` - Missing or invalid token

#### Get All Students
- **URL:** `/api/students`
- **Method:** `GET`
- **Auth Required:** Yes
- **Permissions:** ADMIN, USER
- **Query Parameters:**
  - `page` (optional, default: 0) - Page number
  - `size` (optional, default: 20) - Page size
  - `sort` (optional, default: id,asc) - Sort field and direction
- **Success Response:** `200 OK`
  ```json
  {
    "content": [
      {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com",
        "dateOfBirth": "2000-01-15"
      },
      {
        "id": 2,
        "firstName": "Jane",
        "lastName": "Smith",
        "email": "jane.smith@example.com",
        "dateOfBirth": "1999-05-20"
      }
    ],
    "pageable": {
      "pageNumber": 0,
      "pageSize": 20
    },
    "totalElements": 2,
    "totalPages": 1
  }
  ```
- **Error Response:** `401 Unauthorized`

#### Get Student by ID
- **URL:** `/api/students/{id}`
- **Method:** `GET`
- **Auth Required:** Yes
- **Permissions:** ADMIN, USER
- **URL Parameters:** `id=[Long]` - Student ID
- **Success Response:** `200 OK`
  ```json
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "dateOfBirth": "2000-01-15"
  }
  ```
- **Error Responses:**
  - `404 Not Found`
    ```json
    {
      "timestamp": "2026-01-11T10:30:00",
      "status": 404,
      "message": "Student not found with id: 1"
    }
    ```
  - `401 Unauthorized`

#### Update Student
- **URL:** `/api/students/{id}`
- **Method:** `PUT`
- **Auth Required:** Yes
- **Permissions:** ADMIN only
- **URL Parameters:** `id=[Long]` - Student ID
- **Request Body:**
  ```json
  {
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.updated@example.com",

  }
  ```
- **Success Response:** `200 OK`
  ```json
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.updated@example.com",

  }
  ```
- **Error Responses:**
  - `404 Not Found` - Student not found
  - `400 Bad Request` - Validation errors
  - `403 Forbidden` - Insufficient permissions
  - `401 Unauthorized`






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
spring.datasource.url=jdbc:h2:mem:studentdb
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JWT Configuration
jwt.secret=CFlrMMoGpaR8qKtYTLvrHoRRhO583ZZwhrbr4gB7Bds
jwt.expiration=36000000

