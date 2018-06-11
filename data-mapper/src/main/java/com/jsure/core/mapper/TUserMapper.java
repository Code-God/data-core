package com.jsure.core.mapper;


import com.jsure.core.model.model.TUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    TUser findByUserName(String username);

    TUser selectByUser(TUser record);

    List<TUser> selectUserList(TUser record);
}