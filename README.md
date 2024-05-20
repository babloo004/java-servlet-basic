# java-servlet-basic

## Overview

This project demonstrates a basic web application using an embedded Apache Tomcat server and Jakarta Servlet. The application includes a servlet that handles HTTP requests and responds with a simple "Hello World" message. 

## Project Structure

The project consists of two main classes:

1. `App`: This is the main class that sets up and starts the embedded Tomcat server.
2. `HelloServlet`: This servlet class handles incoming HTTP requests and sends responses.

## Prerequisites

To run this project, ensure you have the following installed:

- Java Development Kit (JDK) 17 or later
- Apache Maven (for building the project)

## Dependencies

The project requires the following dependencies, which are specified in the `pom.xml` file:

1. Jakarta Servlet API
2. Embedded Tomcat server

## Running the Project

1. **Build the Project**: Use Maven to build the project.

    ```bash
    mvn clean install
    ```

2. **Run the Application**: Execute the `App` class to start the embedded Tomcat server.

    ```bash
    java -cp target/classes:target/dependency/* com.avinash.App
    ```

3. **Access the Application**: Open a web browser and navigate to `http://localhost:1234/`. You should see the "Hello World" message.

## Notes

- The Tomcat server is configured to run on port `1234`. If this port is already in use, you can change it by modifying the `tomcat.setPort(1234);` line in the `App` class.
- The `HelloServlet` class extends `HttpServlet` and overrides the `service` method to handle HTTP requests and send responses.

## Conclusion

This project provides a simple example of setting up and running an embedded Tomcat server with a basic servlet. You can extend this project by adding more servlets and configuring them as needed for more complex web applications.
