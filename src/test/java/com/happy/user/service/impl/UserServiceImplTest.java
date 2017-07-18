package com.happy.user.service.impl;

import com.happy.user.model.User;
import com.happy.user.service.UserService;
import com.happy.runner.JUnit4ClassRunner;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collections;
import java.util.List;

/**
 * Created by lirongbo on 2017/7/6.
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class UserServiceImplTest {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Test
    public void getUserById() throws Exception {
        String id = "1";
        User user = userService.getUserById(id);
        logger.info(user.getUserName());
    }

    @Test
    public void getUserByPhoneOrEmail() throws Exception {
        String phone = "13285250574";
        User user = userService.getUserByPhoneOrEmail(phone);
        logger.info(user.getUserName());
    }

    @Test
    public void getAllUser() throws Exception {
        List<User> list = userService.getAllUser();
        //jdk8 新特性
        User result = list.stream()                                     // Convert to steam
                .filter(user -> "赵大宝".equals(user.getUserName()))   // we want "michael" only
                .findAny()                                              // If 'findAny' then return found
                .orElse(null);                                      // If not found, return null　　
        logger.info(result.getId());

        String name = list.stream()
                .filter(user -> "赵大宝".equals(user.getUserName()))
                .map(User::getUserName)                       //convert stream to String
                .findAny()
                .orElse("");
        logger.info(name);

        Collections.sort(list, (a, b) -> b.getId().compareTo(a.getId()));
        list.forEach(user -> logger.info(user.getUserName()));
    }

}