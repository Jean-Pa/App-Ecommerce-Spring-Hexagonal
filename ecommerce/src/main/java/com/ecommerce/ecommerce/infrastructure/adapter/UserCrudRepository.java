package com.ecommerce.ecommerce.infrastructure.adapter;

import com.ecommerce.ecommerce.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<UserEntity,Long> {

    Optional<UserEntity> findByEmail(String email);
}
