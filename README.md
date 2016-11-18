# Spring Boot and Elastic start point

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

#### Creating entity, controller, service:
***

* First of all we need simple plain java object as DTO (in our case it will be User).
  * We will implements this class with help of Lombok library.
  * Follow the source code: [User.java](./src/main/java/io/github/zelinskyi/domain/User.java)

* Lets create controller:
  * Check the source code of controller: [UserController.java](./src/main/java/io/github/zelinskyi/controllers/UserController.java)
  * This is simple Spring Rest controller with two methods.

* Also we need to implement service layer:
  * Check the source code of two classes:
    * [UserService.java](./src/main/java/io/github/zelinskyi/services/UserService.java)
    * [UserServiceImpl.java](./src/main/java/io/github/zelinskyi/services/impl/UserServiceImpl.java)
    

#### Creating repository:
***

* So for now lets move to Elasticsearch part. We need to implement a simple repository.
  Please, check the source code: [UserRepository.java](./src/main/java/io/github/zelinskyi/repositories/UserRepository.java)
  You can see:
  
```java
public interface UserRepository extends ElasticsearchCrudRepository<User, Long> {}
```

* Extending **ElasticsearchCrudRepository** we get basic CRUD functionality to work with Elasticsearch as data source.

So, now we have ready application for running.

Check you project tree structure it should be like in repo:




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