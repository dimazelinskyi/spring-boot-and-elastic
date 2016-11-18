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
