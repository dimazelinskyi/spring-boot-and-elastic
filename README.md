## This repository will contain basic example how to use Elasticsearch with Spring Boot

### Prerequisites:

1. IntelliJ IDEA.
2. Installed Maven and synchronized with IntelliJ

### First step:

1. Create maven project in your IntelliJ IDEA.
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
