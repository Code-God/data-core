package com.jsure.core.innerservice;


import com.jsure.core.exception.CustomException;
import com.jsure.core.mapper.TUserMapper;
import com.jsure.core.model.enums.CustomErrorEnum;
import com.jsure.core.model.model.TUser;
import com.jsure.core.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/1
 * @Time: 10:29
 * I am a Code Man -_-!
 */
@Component
public class InnerUserService {

    @Autowired
    private TUserMapper tUserMapper;

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @param isNullError
     * @return
     */
    public TUser findByUserName(String username, boolean isNullError) {
        TUser user = tUserMapper.findByUserName(username);
        //返回用户名错误
        if (ObjectUtils.isNullOrEmpty(user) && isNullError) {
            throw new CustomException(CustomErrorEnum.ERROR_CODE_341005.getErrorCode(),
                    CustomErrorEnum.ERROR_CODE_341005.getErrorDesc());
        }
        return user;
    }

    /**
     * 更新用户资料信息
     *
     * @param user
     * @return
     */
    public Integer updateUsers(TUser user) {
        Integer r = tUserMapper.updateByPrimaryKeySelective(user);
        if ((ObjectUtils.isNullOrEmpty(r) || r == 0) && user.getIsNullError()) {
            throw new CustomException(CustomErrorEnum.ERROR_CODE_341009.getErrorCode(),
                    CustomErrorEnum.ERROR_CODE_341009.getErrorDesc());
        }
        return r;
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @param isNullError
     * @return
     */
    public TUser findUsesById(Integer id, boolean isNullError) {
        TUser result = tUserMapper.selectByPrimaryKey(id);
        if (ObjectUtils.isNullOrEmpty(result) && isNullError) {
            throw new CustomException(CustomErrorEnum.ERROR_CODE_341001.getErrorCode(),
                    CustomErrorEnum.ERROR_CODE_341001.getErrorDesc());
        }
        return result;
    }

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    public Integer addUsers(TUser user) {
        Integer r = tUserMapper.insertSelective(user);
        if ((ObjectUtils.isNullOrEmpty(r) || r == 0) && user.getIsNullError()) {
            throw new CustomException(CustomErrorEnum.ERROR_CODE_341010.getErrorCode(),
                    CustomErrorEnum.ERROR_CODE_341010.getErrorDesc());
        }
        return r;
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public Integer deleteUsers(Integer id) {
        Integer r = tUserMapper.deleteByPrimaryKey(id);
        if (ObjectUtils.isNullOrEmpty(r) || r == 0) {
            throw new CustomException(CustomErrorEnum.ERROR_CODE_341011.getErrorCode(),
                    CustomErrorEnum.ERROR_CODE_341011.getErrorDesc());
        }
        return r;
    }

    /**
     * 查询用户列表信息
     *
     * @param user
     * @return
     */
    public List<TUser> findUserList(TUser user) {
        List<TUser> list = tUserMapper.selectUserList(user);
        if (ObjectUtils.isNullOrEmpty(list) && user.getIsNullError()) {
            throw new CustomException(CustomErrorEnum.ERROR_CODE_341001.getErrorCode(),
                    CustomErrorEnum.ERROR_CODE_341001.getErrorDesc());
        }
        return list;
    }

}
