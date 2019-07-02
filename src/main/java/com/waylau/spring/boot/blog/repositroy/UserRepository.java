package com.waylau.spring.boot.blog.repositroy;

import com.waylau.spring.boot.blog.domian.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {

}
