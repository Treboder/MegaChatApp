[![Build Maven Project](https://github.com/Treboder/MegaChatApp/actions/workflows/maven-build.yml/badge.svg)](https://github.com/Treboder/MegaChatApp/actions/workflows/maven-build.yml)
[![Push image to Docker Hub](https://github.com/Treboder/MegaChatApp/actions/workflows/docker-publish.yml/badge.svg)](https://github.com/Treboder/MegaChatApp/actions/workflows/docker-publish.yml)
[![Push image to GitHub Container Registry](https://github.com/Treboder/MegaChatApp/actions/workflows/ghcr-publish.yml/badge.svg)](https://github.com/Treboder/MegaChatApp/actions/workflows/ghcr-publish.yml)
[![SSH into server](https://github.com/Treboder/MegaChatApp/actions/workflows/server-login.yml/badge.svg)](https://github.com/Treboder/MegaChatApp/actions/workflows/server-login.yml)
[![Build and deploy to server](https://github.com/Treboder/MegaChatApp/actions/workflows/build-and-deploy.yml/badge.svg)](https://github.com/Treboder/MegaChatApp/actions/workflows/build-and-deploy.yml)

# MegaChatApp

This project demonstrates basic [Spring Boot](https://spring.io/guides/gs/spring-boot/) features 
along with an automated CI pipeline using [Docker](https://www.docker.com/) and [Github Actions](https://github.com/features/actions).

A rudimentary chat application, where users can submit messages along with their username, and those messages (along with the usernames of the users who sent them) will be visible to any user that navigates to the /chat URL. 
Additionally, users can select a message "mode": either Say, Shout, or Whisper. 
Say displays the message as written, while Shout displays the message in all-uppercase, and Whisper displays the message in all-lowercase.
The application also provides simple security mechanism with a signup and login procedure, before any chat features are accessible. 

README.md is also available via [Github Pages](https://treboder.github.io/MegaChatApp/)

The project features:
* [Spring MVC / Spring Boot](https://spring.io/guides/gs/spring-boot/)
* Authorization via [Spring Security](https://spring.io/guides/gs/securing-web/)
* [MyBatis](https://mybatis.org/mybatis-3/) together with [H2 databse](https://www.h2database.com/html/main.html) for data management 
* [Thymeleaf](https://www.thymeleaf.org/) for html integration 
* Web Frontend Testing with [Selenium](https://www.selenium.dev/)
* Containerization via Docker with latest image published to [Docker Hub](https://hub.docker.com/repository/docker/treboder/megachatapp) and [Github Registry](https://github.com/Treboder/MegaChatApp/pkgs/container/megachatapp)
