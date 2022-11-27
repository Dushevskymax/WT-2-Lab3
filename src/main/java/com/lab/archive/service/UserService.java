package com.lab.archive.service;

import com.lab.archive.entity.User;

public interface UserService {

    User signIn(String login, String password);
}
