**IMWApp – Issue Management Web Application**



A simple Issue CRM-style Issue Tracking Management System built using Spring Boot (backend), Hibernate, MySQL(database) and Angular (frontend). Users can create, view, update, delete, and filter issues by priority/status.



 **Setup Instructions**

Backend (Spring Boot)

Install:

Java 17+

Maven

MySQL



**Tools:** 

o Git + GitHub 

o Postman for API testing 

o MySQL Workbench or H2 console 

o VS Code / Spring Tool Suite (STS)



**Create database:**



CREATE DATABASE imwappdb;



Update application.properties:



spring.application.name=IMWApp

server.port=8091



\# MySQL Database Configuration

spring.datasource.url=jdbc:mysql://localhost:3306/imwappdb?createDatabaseIfNotExist=true

spring.datasource.username=root

spring.datasource.password=your\_psword

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver





**Run backend:**



mvn spring-boot:run or run as java application in STS



Frontend (Angular)



Install:



Node.js (16+) here we are using : 22.9.0



Angular CLI here  we are using angular cli : 19.2.16



Go to Angular project folder:



cd frontend





Install dependencies:



npm install





Run Angular app:



ng serve --open



🧰 Technologies Used

**Backend:** 



Java 17

Spring Boot 3.5.7



Spring Data JPA



Hibernate 8.0



MySQL 



Lombok



Validation API



REST API



**Frontend**



Angular 16+



Bootstrap / Material



TypeScript



HTML / CSS



**API Endpoints List (Issue Module)**

Create Issue

POST /api/issues/createIssue



Body:



{

&nbsp; "title": "CRM dashboard not loading",

&nbsp; "description": "Dashboard graph and KPI cards not loading for regional admin",

&nbsp; "priority": "HIGH",

&nbsp; "status": "OPEN",

&nbsp; "assignee": "Rahul Sharma"

}



Get Issue by ID

GET /api/issues/findById/{id}



Get All Issues

GET /api/issues/findAll



Filter by Priority

GET /api/issues/findByPriority/{priority}



Filter by Status

GET /api/issues/findByStatus/{status}



Filter by Priority \& Status

GET /api/issues/findByPriorityAndStatus/{priority}/{status}



Update Issue

PUT /api/issues/updateIssue/{id}



Delete Issue

DELETE /api/issues/deleteById/{id}

