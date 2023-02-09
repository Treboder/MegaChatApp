[![Build Maven Project](https://github.com/Treboder/MegaChatApp/actions/workflows/maven-build.yml/badge.svg)](https://github.com/Treboder/MegaChatApp/actions/workflows/maven-build.yml)


# MegaChatApp

This project demonstrates basic [Spring Boot](https://spring.io/guides/gs/spring-boot/) features 
along with an automated CI pipeline using [Docker](https://www.docker.com/) and [Github Actions](https://github.com/features/actions).

A rudimentary chat application, where users can submit messages along with their username, and those messages (along with the usernames of the users who sent them) will be visible to any user that navigates to the /chat URL. 
Additionally, users can select a message "mode": either Say, Shout, or Whisper. 
Say displays the message as written, while Shout displays the message in all-uppercase, and Whisper displays the message in all-lowercase.
The application also provides simple security mechanism with a signup and login procedure, before any chat features are accessible. 


The project features:
* [Spring MVC / Spring Boot](https://spring.io/guides/gs/spring-boot/)
* Authorization via [Spring Security](https://spring.io/guides/gs/securing-web/)
* [MyBatis](https://mybatis.org/mybatis-3/) together with [H2 databse](https://www.h2database.com/html/main.html) for data management 
* [Thymeleaf](https://www.thymeleaf.org/) for html integration 
* Web Frontend Testing with [Selenium](https://www.selenium.dev/)
* Docker
* Github Registry


# Selenium vs. local browser environment

You might observe that Selenium test results depend on your local browser settings.
In case of failing tests, we make sure that jars are build with:
````
mvn -fn clean install
````
or
````
mvn clean package -Dmaven.test.skip=true
````