package io.github.zelinskyi.repositories;


import io.github.zelinskyi.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface UserRepository extends ElasticsearchCrudRepository<User, Long> {}
