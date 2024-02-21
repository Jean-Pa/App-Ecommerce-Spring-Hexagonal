package com.ecommerce.ecommerce.application.repository;

import com.ecommerce.ecommerce.domain.User;

public interface UserRepository {

    public User createUser(User user);
    public User findByEmail(String email);

    public User fndById(Long id);
}
