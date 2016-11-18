package io.github.dimazelinskyi.springboot.elastic.repositories;


import io.github.dimazelinskyi.springboot.elastic.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface UserRepository extends ElasticsearchCrudRepository<User, Long> {}
