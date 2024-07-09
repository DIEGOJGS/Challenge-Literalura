# Challenge-Literalura

## Descripción

LiterAlura es una aplicación de consola desarrollada en Java utilizando Spring Boot. El objetivo principal de esta aplicación es crear un catálogo de libros interactivo que permite a los usuarios buscar y listar libros y autores, así como guardar esta información en una base de datos PostgreSQL.

## Características

- Buscar libros por título utilizando la API de Gutendex.
- Listar todos los libros guardados en la base de datos.
- Listar libros por idioma.
- Listar autores guardados en la base de datos.
- Listar autores vivos en un año determinado.
- Guardar la información de los libros y autores en una base de datos PostgreSQL.

## Requisitos

- Java JDK 17 o superior.
- Maven 4 o superior.
- Spring Boot 3.2.3.
- PostgreSQL 16 o superior.
- IntelliJ IDEA (opcional).

## Configuración del Entorno

### 1. Instalar Java y Maven

- Descargar e instalar [Java JDK](https://www.oracle.com/java/technologies/downloads/).
- Descargar e instalar [Maven](https://maven.apache.org/download.cgi).

### 2. Configurar PostgreSQL

- Descargar e instalar [PostgreSQL](https://www.postgresql.org/download/).
- Crear una base de datos llamada `postgres`.

### 3. Configurar el Proyecto

- Clonar este repositorio.
- Configurar las propiedades de la base de datos en `src/main/resources/application.properties`:

  ```properties
  spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
  spring.datasource.username=postgres
  spring.datasource.password=admin
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.format_sql=true
  spring.main.allow-bean-definition-overriding=true

### 4. Estructura del Proyecto

     ```LiterAlura/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/
    │   │   │       └── literatura/
    │   │   │           └── literalura/
    │   │   │               ├── client/
    │   │   │               │   └── GutendexClient.java
    │   │   │               ├── config/
    │   │   │               │   └── RestTemplateConfig.java
    │   │   │               ├── controller/
    │   │   │               │   └── MainController.java
    │   │   │               ├── model/
    │   │   │               │   ├── Autor.java
    │   │   │               │   ├── Libro.java
    │   │   │               │   └── GutendexResponse.java
    │   │   │               ├── repository/
    │   │   │               │   ├── AutorRepository.java
    │   │   │               │   └── LibroRepository.java
    │   │   │               └── LiterAluraApplication.java
    │   │   └── resources/
    │   │       └── application.properties
    │   ├── test/
    │   │   └── java/
    │   │       └── com/
    │   │           └── literatura/
    │   │               └── literalura/
    │   │                   └── LiterAluraApplicationTests.java
    └── pom.xml

### 5. Dependencias del Proyecto

  ```Dependencias
  Las principales dependencias del proyecto se encuentran en el archivo pom.xml:
  
  <dependencies>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-data-jpa</artifactId>
      </dependency>
      <dependency>
          <groupId>org.postgresql</groupId>
          <artifactId>postgresql</artifactId>
          <scope>runtime</scope>
      </dependency>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-web</artifactId>
      </dependency>
      <dependency>
          <groupId>com.fasterxml.jackson.core</groupId>
          <artifactId>jackson-databind</artifactId>
      </dependency>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-test</artifactId>
          <scope>test</scope>
      </dependency>
  </dependencies>
