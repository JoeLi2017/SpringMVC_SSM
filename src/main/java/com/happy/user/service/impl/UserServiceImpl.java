package com.happy.user.service.impl;

import com.happy.user.dao.UserDao;
import com.happy.user.model.User;
import com.happy.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lirongbo on 2017/7/6.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    public User getUserById(String userId) {
        return userDao.selectUserById(userId);
    }

    public User getUserByPhoneOrEmail(String emailOrPhone) {
        return userDao.selectUserByPhoneOrEmail(emailOrPhone);
    }

    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

}
