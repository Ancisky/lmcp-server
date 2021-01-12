package com.kglab.lmcp.controller.login;

import com.kglab.lmcp.service.UserLogin.UserLoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * TODO  $
 *
 * @author sc
 * @date 2021/1/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserLoginApiTest {
    @Autowired
    UserLoginApi userLoginApi;

    @Test
    public void validateLoginForm() {
        userLoginApi.checkUsernameAndPasswordString("sc","123");
    }
}