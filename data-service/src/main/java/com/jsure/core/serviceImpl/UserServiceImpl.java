package com.jsure.core.serviceImpl;


import com.google.common.collect.Maps;
import com.jsure.core.model.model.TUser;
import com.jsure.core.model.param.UserParam;
import com.jsure.core.model.result.TUserResult;
import com.jsure.core.utils.BeanMapper;
import com.jsure.core.check.InnerUserCheck;
import com.jsure.core.innerservice.InnerUserService;
import com.jsure.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/5/21
 * @Time: 15:09
 * I am a Code Man -_-!
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private InnerUserService innerUserService;

    @Autowired
    private InnerUserCheck innerUserCheck;


    /**
     * 查询用户列表信息
     *
     * @param userPram
     * @return
     */
    @Override
    public List<TUserResult> findUserList(UserParam userPram) {
        innerUserCheck.checkUserParam(userPram);
        TUser user = new TUser();
        BeanMapper.copy(userPram, user);
        List<TUser> list = innerUserService.findUserList(user);
        List<TUserResult> r = BeanMapper.mapList(list, TUserResult.class);
        return r;
    }

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public Integer addUsers(TUser user) {
        //创建用户
        Integer i = innerUserService.addUsers(user);
        return i;
    }

}
