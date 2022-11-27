package com.lab.archive.dao;

import com.lab.archive.criteria.Criteria;
import com.lab.archive.dao.exception.DAOException;
import com.lab.archive.entity.User;
import java.util.List;

public interface UserDAO {
    List<User> find(Criteria criteria) throws DAOException;
}
