package com.kglab.lmcp.repository.graph;

import com.kglab.lmcp.repository.table.UserDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @org.junit.Test
    public void findByName() {
        System.out.println(userDao.findByName("舒超").size());
    }

    @org.junit.Test
    public void findByNameLike() {
        System.out.println(userDao.findByNameLike("%舒%").size());
    }

    @org.junit.Test
    public void findByUsername() {
        System.out.println(userDao.findByUsername("sc").toString());
    }

    @org.junit.Test
    public void findByUsernameAndPassword() {
        System.out.println(userDao.findByUsernameAndPassword("sc","123").toString());
    }

    @org.junit.Test
    public void queryUserPassowrd() {
        System.out.println(userDao.queryUserPassowrd("sc").toString());
    }

}