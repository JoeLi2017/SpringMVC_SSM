package com.happy.user.service;

import com.happy.user.model.User;

import java.util.List;

/**
 * Created by lirongbo on 2017/7/6.
 */
public interface UserService {

    List<User> getAllUser();

    User getUserByPhoneOrEmail(String emailOrPhone);

    User getUserById(String userId);

}
