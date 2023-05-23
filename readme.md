
# Music Streaming Service API

This repository contains the source code for a Music Streaming Service API. It provides endpoints to manage users, songs, and playlists. The API is developed using Java and Spring Boot.

## Access Documentation here
url_Ec2--->http://3.111.169.143:8080/swagger-ui/index.html#/

## Prerequisites


Before running the project, ensure that the following prerequisites are met:

- [Java JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- Spring boot MVN

Please make sure you have Java JDK 11 and Maven installed on your machine before proceeding with the installation and usage steps.

## Models

### User

The `User` model represents a user in the system.

Attributes:
- `id` (Long): The unique identifier of the user.
- `username` (String): The username of the user.
- `password` (String): The password of the user.
- `role` (UserRole): The role of the user (ADMIN or USER_ROLE).

### Song

The `Song` model represents a song in the music streaming service.

Attributes:
- `id` (Long): The unique identifier of the song.
- `title` (String): The title of the song.
- `artist` (String): The artist of the song.
- `genre` (String): The genre of the song.

### Playlist

The `Playlist` model represents a playlist created by a user.

Attributes:
- `id` (Long): The unique identifier of the playlist.
- `name` (String): The name of the playlist.
- `user` (User): The user who created the playlist.
- `songs` (List<Song>): The list of songs in the playlist.

## Controllers

### UserController

The `UserController` handles user-related operations.

Endpoints:
- `POST /users/register`: Registers a new user.
- `POST /users/password/reset`: Resets the password for a user.
- `GET /users/{id}`: Retrieves a user by ID.
- `GET /users/`: Retrieves all users.
- `PUT /users/{id}`: Updates a user.
- `DELETE /users/{id}`: Deletes a user.

### SongController

The `SongController` handles song-related operations.

Endpoints:
- `POST /songs/`: Adds a new song (requires ADMIN role).
- `GET /songs/`: Retrieves all songs.
- `GET /songs/{id}`: Retrieves a song by ID.
- `PUT /songs/{id}`: Updates a song (requires ADMIN role).
- `DELETE /songs/{id}`: Deletes a song (requires ADMIN role).

### PlaylistController

The `PlaylistController` handles playlist-related operations.

Endpoints:
- `POST /playlists/`: Creates a new playlist (requires USER_ROLE).
- `GET /playlists/`: Retrieves all playlists.
- `GET /playlists/{id}`: Retrieves a playlist by ID.
- `PUT /playlists/{id}`: Updates a playlist (requires USER_ROLE).
- `DELETE /playlists/{id}`: Deletes a playlist (requires USER_ROLE).

## Configuration

### SecurityConfig

The `SecurityConfig` class provides configuration for security-related settings.

- PasswordEncoder: Configures the password encoder for user password hashing.
  
  
## Deployment
The application can be deployed to a server or cloud platform of your choice. In this case, the project has been deployed on an EC2 instance.

To deploy the application:
## Summary

The Music API is designed to simplify the process of fetching music-related data for developers. It offers a comprehensive set of endpoints that enable users to retrieve information about artists, albums, tracks, genres, and more. The API leverages the Spring Boot framework and Java programming language to ensure high performance, scalability, and reliability.

## Goal

The goal of the Music API project is to provide a user-friendly and efficient solution for developers who require access to music-related data. By offering a range of well-documented endpoints, the API aims to streamline the retrieval process and empower developers to build innovative and feature-rich music applications. The project prioritizes ease of use, robustness, and adherence to industry standards.

---



## Getting Started
To run the application locally, follow these steps:

Clone the repository: git clone <repository-url>
Configure the application.properties file as described above.
Build the project: ./mvnw clean install
Run the application: ./mvnw spring-boot:run
The application will be accessible at http://localhost:8080
Make sure you have Java and Maven installed on your system before running the application.


Set up an EC2 instance and configure it with the necessary environment.
Build the project: ./mvnw clean install
Transfer the generated JAR file to the EC2 instance.
Run the application: java -jar music-streaming-service-api.jar
The application will be accessible at http://your-ec2-instance-ip:8080
Remember to update the security settings, database configuration, and any other necessary configurations based on your deployment environment.

Contributing
Contributions to this project are welcome. Feel free to submit bug reports, feature requests, or pull requests.

## Application Properties

The `application.properties` file contains the configuration properties for the application. Here are the contents of the file:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/music_streaming_service_db
spring.datasource.username=db_username
spring.datasource.password=db_password

# Hibernate Configuration
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jpa.hibernate.ddl-auto=update

# Spring Security Configuration
spring.security.user.name=admin_username
spring.security.user.password=admin_password
spring.security.user.roles=ADMIN

# Server Configuration
server.port=8080
Please replace db_username, db_password, admin_username, and admin_password with your actual database and administrator credentials.
