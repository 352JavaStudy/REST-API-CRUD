package com.rest.study.User.service;

import com.rest.study.User.entity.User;

public interface UserService {
    User findByUserId(String freeUserId);
}
