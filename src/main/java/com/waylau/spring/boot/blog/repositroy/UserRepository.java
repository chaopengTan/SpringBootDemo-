package com.waylau.spring.boot.blog.repositroy;

import com.waylau.spring.boot.blog.domian.User;

import java.util.List;

public interface UserRepository {
    User saveOrUpdateUser(User user);
    void deleteUser(Long id);
    User getUserById(Long id);
    List<User> listUser();
}
