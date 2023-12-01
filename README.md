"# Gestion-des-Clubs-Spring-Boot-Angular" 

# Project Name

Project for Club Management - Spring Boot Backend

## Description

This project was developed by TORIEN and Nour El Houda as part of the Spring Boot course project at Ecole Nationale d'Ingénieurs de Carthage, Tunisia, for the academic year 2022-2023 (second year).

## Project Overview

The project serves as the backend for a club management system within the university. It is developed using Spring Boot and Spring Tool Suite (STS) as the Integrated Development Environment (IDE). The backend interacts with a MySQL database, and it is intended to work in conjunction with a corresponding Angular frontend.

## Launching the Project

1. Download the project from [link_to_project_repository].
2. Start a local MySQL server (WAMP SERVER, XAMPP, or WORKBENCH SQL).
3. Open this project in STS (or other IDE like Eclipse ,..)
4. Test it using POSTMAN or FrontEnd link below


## Frontend

The frontend for this project is implemented in Angular. You can find the frontend code at https://github.com/Torien-TORIEN/Project_ClubManagement_SpringBoot_Angular_FrontEnd.

## Instructions
1. Download project 
2. Open it in IDE like STS or Eclipse ...
3. Install the dependencies : Right click the project and Maven->Update Project...->Force Update Snapshots/Releases -> OK
4. Launch MySQL Server (XAMP, WAMP SERVER, ...) [ Gestionclubdb automatically created by this project]
5. Run the project: Right Click -> Run as -> Spring Boot App
6. Use your Browser to test it (ex : http://localhost:8081/SpringMVC/servlet/users) or Postman or Launch FrontEnd
7. Project Properties in :src/main/resources/application.properties 



## Dependencies

### 1. Maven
   - **Description:** Apache Maven is a build automation and project management tool used to manage the project's build lifecycle.

### 2. MySQL Driver
   - **Group ID:** com.mysql
   - **Artifact ID:** mysql-connector-j
   - **Scope:** runtime
   - **Description:** Official MySQL JDBC driver for connecting Java applications to MySQL databases.

### 3. Spring Boot Starter Data JPA
   - **Group ID:** org.springframework.boot
   - **Artifact ID:** spring-boot-starter-data-jpa
   - **Description:** Starter for using Spring Data JPA with Hibernate.

### 4. Spring Boot Starter Web
   - **Group ID:** org.springframework.boot
   - **Artifact ID:** spring-boot-starter-web
   - **Description:** Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container.

### 5. Spring Boot DevTools
   - **Group ID:** org.springframework.boot
   - **Artifact ID:** spring-boot-devtools
   - **Scope:** runtime
   - **Optional:** true
   - **Description:** Provides fast application restarts, LiveReload, and more for development.

### 6. Lombok
   - **Group ID:** org.projectlombok
   - **Artifact ID:** lombok
   - **Optional:** true
   - **Description:** Library that helps reduce boilerplate code by automatically generating getters, setters, and other commonly used methods.

### 7. Spring Boot Starter Test
   - **Group ID:** org.springframework.boot
   - **Artifact ID:** spring-boot-starter-test
   - **Scope:** test
   - **Description:** Starter for testing Spring Boot applications with JUnit, TestNG, or other testing frameworks.


## Contributing

If you would like to contribute to this project, please [provide instructions or guidelines for contributions].

## License
MIT Licence
Copyright (c) 2023 TORIEN and Nour El Houda [ENICarthage]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to use,
copy, modify, merge, publish, distribute, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS," WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE, AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES, OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT, OR OTHERWISE, ARISING FROM,
OUT OF, OR IN CONNECTION WITH THE SOFTWARE, OR THE USE, OR OTHER DEALINGS IN
THE SOFTWARE.


