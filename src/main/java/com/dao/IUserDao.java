package com.dao;
/**
 * Dao接口
 */

import com.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
