package io.github.dimazelinskyi.repositories;


import io.github.dimazelinskyi.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface UserRepository extends ElasticsearchCrudRepository<User, Long> {}
