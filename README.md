# Contact Book

A prototype of a contact book written in Java. 

## Project Structure
The project follows the model-view-controller design pattern and has an N-tier structure with the database layer, the DAO layer for interaction with the database, the service layer which contains the business logic, the HTTP request processing layer, and the data presentation layer.  
The DAO layer is implemented with Hibernate, and DTOs are used for data transfer between program tiers.    

## Technologies Used

 - Java 11
 - Spring Boot
 - Spring Web MVC
 - Spring Security
 - Thymeleaf
 - Apache Tomcat
 - MySQL RDBMS
 - Lombok
 - Log4j
 - Maven 3.1.1
 - Maven Checkstyle Plugin

## Running the Project

To run the project on your local machine, clone this project into your local folder and open the project in an IDE. 

Configure Tomcat Server and set up the MySQL DS and MySQL Workbench on your machine. 

Insert your own MySQL username and login in `application.properties` file or reconfigure the properties to work with your DB of choice.

Make sure you've installed and activated the Lombok plugin for your IDE before you launch the application for the first time.

The User and Admin are injected into the DB when the application starts. 
To log in as the Admin, use these credentials: email `admin@gmail.com` & password `1234`.
And to log in as the User, use: email `user@gmail.com` & password `1234`.

The data base is recreated from scratch every time you start the application.

## Author

[Anastasiia Melnyk](https://github.com/AnaLanda)
