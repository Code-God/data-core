package com.jsure.core.controller;

import com.jsure.core.constant.CustomConstant;
import com.jsure.core.exception.CustomException;
import com.jsure.core.model.model.TUser;
import com.jsure.core.model.param.UserParam;
import com.jsure.core.model.result.TUserResult;
import com.jsure.core.service.UserService;
import com.jsure.core.utils.Response;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/6/7
 * @Time: 11:41
 * I am a Code Man -_-!
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/server")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户列表
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "查询用户列表", notes = "查询用户列表,含分页排序")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Response<List<TUserResult>> findUserList(UserParam user) {
        Response<List<TUserResult>> result = new Response<>();
        try {
            List<TUserResult> users = userService.findUserList(user);
            result.setResult(users);
            successResult(result, CustomConstant.USER_INFO_SUCCESS);
            log.info("success to findUserList, RESULT:{}", result);
        } catch (CustomException e) {
            failedResult(result, e.getCode(), e.getMessage());
            log.error("failed to findUserList, RESULT:{},cause:{}", result, e);
        } catch (Exception e) {
            failedResult(result);
            log.error("failed to findUserList, RESULT:{},cause:{}", result, e);
        }
        return result;
    }

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户", notes = "创建用户，返回创建后的用户信息")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "TUser")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Response<Integer> addUsers(@RequestBody TUser user) {
        Response<Integer> result = new Response<>();
        try {
            Integer i = userService.addUsers(user);
            result.setResult(i);
            successResult(result, CustomConstant.CREATE_USER_SUCCESS);
            log.info("success to addUser, RESULT:{}", result);
        } catch (CustomException e) {
            failedResult(result, e.getCode(), e.getMessage());
            log.error("failed to addUser, RESULT:{},cause:{}", result, e);
        } catch (Exception e) {
            failedResult(result);
            log.error("failed to addUser, RESULT:{},cause:{}", result, e);
        }
        return result;
    }
}
