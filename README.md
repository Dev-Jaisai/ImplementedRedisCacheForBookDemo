# Bookstore Project

This is a sample project for storing book information into a database using Redis caching.

## Introduction

The Bookstore project is a simple Spring Boot application that demonstrates how to store and retrieve book information from a database while utilizing Redis caching for improved performance.

## Features

- Store book information (title, author, price) in a database.
- Retrieve book information from the database.
- Utilize Redis caching to improve performance by caching book data.

## Dependencies

To run this project, you will need:

- Java Development Kit (JDK) 8 or higher
- Maven
- Redis Server

## Installation and Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/bookstore.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd bookstore
    ```

3. **Build the project:**

    ```bash
    mvn clean install
    ```

4. **Run the application:**

    ```bash
    java -jar target/bookstore.jar
    ```

5. **Start Redis Server:**

    Start the Redis server on localhost with default port 6379.

## Usage

Once the application is running, you can interact with it using RESTful endpoints to store and retrieve book information.

- **Store Book Information:**
  - Endpoint: `POST /api/books`
  - Request Body: JSON containing book information (title, author, price)
  
  Example:
  ```json
  {
      "title": "Sample Book",
      "author": "John Doe",
      "price": 29.99
  }
