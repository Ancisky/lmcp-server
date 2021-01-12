package com.kglab.lmcp.controller.login;

import com.kglab.lmcp.controller.BaseAction;
import com.kglab.lmcp.entity.vo.ResultVo;
import com.kglab.lmcp.service.UserLogin.UserLoginService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@Validated
@RequestMapping("login")
public class UserLoginApi extends BaseAction {

    final UserLoginService userLoginService;

    protected UserLoginApi(UserLoginService s1){
        this.userLoginService = s1;
    }

    @RequestMapping("checkup")
    public void checkUsernameAndPasswordString (
            @NotBlank(message = "用户名不能为空") String username,
            @NotBlank(message = "密码不能为空") String password)
    {
        userLoginService.validateLoginForm(username,password);
    }
}
