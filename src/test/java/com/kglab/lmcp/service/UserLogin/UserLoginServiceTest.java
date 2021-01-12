package com.kglab.lmcp.service.UserLogin;

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
public class UserLoginServiceTest {

    @Autowired  UserLoginService userLoginService;

    @Test
    public void validateLoginForm() {
        userLoginService.validateLoginForm("sc","123");
    }
}