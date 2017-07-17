package com.happy.user.dao;

import com.happy.user.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lirongbo on 2017/7/6.
 */
@Repository
public interface UserDao {

    User selectUserById(@Param("userId") String userId);

    User selectUserByPhoneOrEmail(@Param("emailOrPhone") String emailOrPhone);

    List<User> selectAllUser();

}
