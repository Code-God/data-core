package com.jsure.core.check;

import com.jsure.core.exception.CustomException;
import com.jsure.core.model.enums.CustomErrorEnum;
import com.jsure.core.model.param.UserParam;
import com.jsure.core.utils.ObjectUtils;
import org.springframework.stereotype.Component;

/**
 * @Author: wuxiaobiao
 * @Description:
 * @Date: Created in 2018/5/30
 * @Time: 12:34
 * I am a Code Man -_-!
 */
@Component
public class InnerUserCheck {

    /**
     * 校验参数
     * @param userParam
     * @return
     */
    public UserParam checkUserParam(UserParam userParam){
        if(ObjectUtils.isNullOrEmpty(userParam)){
            throw new CustomException(CustomErrorEnum.ERROR_CODE_341002.getErrorCode(),
                    CustomErrorEnum.ERROR_CODE_341002.getErrorDesc());
        }
        if(ObjectUtils.isNotNullAndEmpty(userParam.getPageCurrent())){
            userParam.setPageCurrent((userParam.getPageCurrent()-1) * userParam.getPageSize());
        }
        return userParam;
    }
}
