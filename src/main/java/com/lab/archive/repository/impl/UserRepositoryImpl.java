package com.lab.archive.repository.impl;

import com.lab.archive.criteria.Criteria;
import com.lab.archive.dao.UserDAO;
import com.lab.archive.dao.exception.DAOException;
import com.lab.archive.entity.User;
import com.lab.archive.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    private final UserDAO userDAO;

    public UserRepositoryImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User findByLogin(String login) {
        var criteria = new Criteria();
        criteria.add("name", login);
        try {
            return userDAO.find(criteria).get(0);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }
}
