# Spring Boot and Elastic :: starting point

***

![alt text](./etc/sb_el_2.png "Spring Boot and Elastic")

***

### 1. Project structure

![alt text](./etc/tree.png "Project structure")

***

### 2. Maven [pom.xml](./pom.xml)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>io.github.zelinskyi</groupId>
    <artifactId>spring-boot-and-elastic</artifactId>
    <version>1.0-SNAPSHOT</version>
    <name>Spring Boot and Elastic</name>


    <!--Spring Boot parent pom in dependency management section, so we don't need
      to add it as parent for this project. More information:
        https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-build-systems.html#using-boot-maven-without-a-parent-->

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>1.4.2.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <properties>
        <lombok.version>1.16.8</lombok.version>
        <json-path-assert.version>2.2.0</json-path-assert.version>
    </properties>

    <dependencies>

        <!--Allows to create simple RESTful web service-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!--Allows to work with Elastic Spring Data in Spring Boot-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
        </dependency>

        <!--Simplifying creation POJO library (no setters no getters)-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${lombok.version}</version>
        </dependency>

        <!--Allows to test Spring Boot apps-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!--Helping library to check json during testing-->
        <dependency>
            <groupId>com.jayway.jsonpath</groupId>
            <artifactId>json-path-assert</artifactId>
            <version>${json-path-assert.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```
***

### 3. Creating entity: [User.java](./src/main/java/io/github/dimazelinskyi/springboot/elastic/domain/User.java)

  ```java
  package io.github.dimazelinskyi.springboot.elastic.domain;
  
  import lombok.Getter;
  import lombok.Setter;
  import org.springframework.data.annotation.Id;
  import org.springframework.data.elasticsearch.annotations.Document;
  
  @Document(indexName = "user")
  @Getter
  @Setter
  public class User {
  
      @Id
      private long id;
      private String firstName;
      private String lastName;
  }
  ```
***

### 4. Creating repository: [UserRepository.java](./src/main/java/io/github/dimazelinskyi/springboot/elastic/repositories/UserRepository.java)

```java
public interface UserRepository extends ElasticsearchCrudRepository<User, Long> {

}
```
***

### 5. Creating service and implementation:
### a. [UserService.java](./src/main/java/io/github/dimazelinskyi/springboot/elastic/services/UserService.java) 

```java
package io.github.dimazelinskyi.springboot.elastic.services;


import io.github.dimazelinskyi.springboot.elastic.domain.User;

public interface UserService {

    void save(User user);
    User find(Long id);
}
```
### b. [UserServiceImpl.java](./src/main/java/io/github/dimazelinskyi/springboot/elastic/services/impl/UserServiceImpl.java)

```java
package io.github.dimazelinskyi.springboot.elastic.services.impl;

import io.github.dimazelinskyi.springboot.elastic.domain.User;
import io.github.dimazelinskyi.springboot.elastic.repositories.UserRepository;
import io.github.dimazelinskyi.springboot.elastic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User find(Long id) {
        return userRepository.findOne(id);
    }
}
```
***
### 6. Creating Spring Boot runner [SpringBootElasticsearchRunner.java](./src/main/java/io/github/dimazelinskyi/springboot/elastic/SpringBootElasticsearchRunner.java):
  
  ```java
  package io.github.dimazelinskyi.springboot.elastic;
  
  
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  
  @SpringBootApplication
  public class SpringBootElasticsearchRunner {
  
      public static void main(String[] args) {
          SpringApplication.run(SpringBootElasticsearchRunner.class);
      }
  }
  ```

#### Run and check implementation:
***

Lets run application and check it:

* To run it just run the class **SpringBootElasticsearchRunner**

Now we can check our creation and searching user by invoking url with payload:

* To check creation of user invoke this url with next JSON payload using POST HTTP method: 

```
127.0.0.1:8080/user
```


```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Smith"
}
```

* To check the searching of user just invoke the url using GET HTTP method:

```
127.0.0.1:8080/user/1
```

You should see the answer like: 

```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Smith"
}
```