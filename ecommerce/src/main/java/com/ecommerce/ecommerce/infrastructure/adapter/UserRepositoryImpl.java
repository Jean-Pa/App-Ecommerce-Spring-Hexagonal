package com.ecommerce.ecommerce.infrastructure.adapter;

import com.ecommerce.ecommerce.application.repository.UserRepository;
import com.ecommerce.ecommerce.domain.User;
import com.ecommerce.ecommerce.infrastructure.mapper.UserMapper;

public class UserRepositoryImpl implements UserRepository {

    private final UserCrudRepository userCrudRepository;
    private final UserMapper userMapper;

    public UserRepositoryImpl(UserCrudRepository userCrudRepository, UserMapper userMapper) {
        this.userCrudRepository = userCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(User user) {
        return userMapper.toUser(userCrudRepository.save(userMapper.toUserEntity(user)));
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.toUser(userCrudRepository.findByEmail(email).get());
    }

    @Override
    public User fndById(Long id) {
        return userMapper.toUser(userCrudRepository.findById(id).get());
    }
}
