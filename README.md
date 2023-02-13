[![Build Maven Project](https://github.com/Treboder/MegaChatApp/actions/workflows/maven-build.yml/badge.svg)](https://github.com/Treboder/MegaChatApp/actions/workflows/maven-build.yml)
[![Build and push to Docker Hub](https://github.com/Treboder/MegaChatApp/actions/workflows/build-push-dockerhub.yml/badge.svg)](https://github.com/Treboder/MegaChatApp/actions/workflows/build-push-dockerhub.yml)
[![Build and push to GitHub Container Registry](https://github.com/Treboder/MegaChatApp/actions/workflows/build-push-ghcr.yml/badge.svg)](https://github.com/Treboder/MegaChatApp/actions/workflows/build-push-ghcr.yml)
[![SSH into server via appleboy](https://github.com/Treboder/MegaChatApp/actions/workflows/server-login-appleboy.yml/badge.svg)](https://github.com/Treboder/MegaChatApp/actions/workflows/server-login-appleboy.yml)
[![SSH into server directly](https://github.com/Treboder/MegaChatApp/actions/workflows/server-login-direct.yml/badge.svg)](https://github.com/Treboder/MegaChatApp/actions/workflows/server-login-direct.yml)
[![Build, deploy and run the app](https://github.com/Treboder/MegaChatApp/actions/workflows/build-deploy-run.yml/badge.svg)](https://github.com/Treboder/MegaChatApp/actions/workflows/build-deploy-run.yml)

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

## EC2 Setup

We use AWS EC2 with Ubuntu, but experienced following connection problem with Amazon Linux:

````ssh: handshake failed: ssh: unable to authenticate, attempted methods [none publickey], no supported methods remain````

Since we deploy and run the app containerized, we need to install Docker on our target machine as described in [how-to-install-and-use-docker-on-ubuntu](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04)

````
sudo apt update
sudo apt install apt-transport-https ca-certificates curl software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"
apt-cache policy docker-ce
sudo apt install docker-ce
sudo systemctl status docker
````

## Docker Login from EC2 via Github Actions (with Github secrets)

Seems not to work (at least I do not know how) according to the error message 
*"Cannot perform an interactive login from a non TTY device"* after trying to login via Github Actions with:
````
docker login -u $DOCKER_USER -p $DOCKER_PWD
````

## Docker Login from EC2 via Github Actions (without Github secrets)

In order to avoid the above mentioned docker login issue, we do not use Github secrets.
We rather pass the docker hub key from a file via stdin to the login command.
To do so, just create the file *docker.pwd* with the docker hub key in the home directory and run:
````
cat docker.pwd | sudo docker login --username treboder --password-stdin
````


# References

* [ci-cd-hands-on-github-actions-docker-hub-aws-ec2](https://medium.com/ryanjang-devnotes/ci-cd-hands-on-github-actions-docker-hub-aws-ec2-ba09f80297e1)