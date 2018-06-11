package com.jsure.core.service;


import com.jsure.core.model.model.TUser;
import com.jsure.core.model.param.UserParam;
import com.jsure.core.model.result.TUserResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/5/21
 * @Time: 15:07
 * I am a Code Man -_-!
 */
public interface UserService {

    List<TUserResult> findUserList(UserParam users);

    Integer addUsers(TUser user);
}
