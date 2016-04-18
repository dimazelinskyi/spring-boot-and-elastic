![alt text](./etc/sb_el.png "Spring Boot and Elasticsearch")


## Very simple example of usage Elasticsearch and Spring Boot together

#### Some short info from Wikipedia:
 1. **Elasticsearch** - is a search server based on Lucene.
 2. **Spring Boot** - is Spring's convention-over-configuration solution for creating stand-alone, production-grade Spring based Applications that you can "just run".

#### Prerequisites:

1. Installed Java IDE (In my case I will use IntelliJ IDEA‎).
2. Installed Maven and synchronized with your IDE.

##### First step:

1. Create maven project in your IDE.
2. Add dependencies:

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>1.3.3.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
