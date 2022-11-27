package com.lab.archive.repository;

import com.lab.archive.entity.User;

public interface UserRepository {
    User findByLogin(String login);
}
