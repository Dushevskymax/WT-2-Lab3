package com.lab.archive.dao.impl;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lab.archive.dao.exception.DAOException;
import com.lab.archive.dao.wrapper.UserWrapper;
import com.lab.archive.criteria.Criteria;
import com.lab.archive.dao.UserDAO;
import com.lab.archive.entity.User;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final String PATH
        = "C:\\Users\\fromt\\IdeaSpace\\WTLab3\\src\\main\\resources\\datafolder\\user_db.xml";

    @Override
    public List<User> find(Criteria criteria) throws DAOException {
        try (var fileInputStream = new FileInputStream(PATH)) {

            var mapper = new XmlMapper();
            var xmlString = new String(fileInputStream.readAllBytes());
            var users = mapper.readValue(xmlString, UserWrapper.class).getUsers();

            var criteriaMap = criteria.getCriteriaMap();
            var result = new ArrayList<User>();
            if (criteriaMap.isEmpty()) {
                return users;
            } else {
                criteriaMap.forEach((key, value) -> result.addAll(
                    users.stream().filter(p -> {
                        try {
                            var field = p.getClass().getDeclaredField(key);
                            field.setAccessible(true);
                            return field.get(p).equals(value);
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }).toList()
                ));
            }
            return result;
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }
}
