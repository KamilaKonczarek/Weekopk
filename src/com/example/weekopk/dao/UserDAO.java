package com.example.weekopk.dao;

import com.example.weekopk.model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long>{

    List<User> getAll(); // uważam, że mogłoby tego nie być
    User getUserByUsername(String username);
}
