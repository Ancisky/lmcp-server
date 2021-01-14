package com.kglab.lmcp;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/**
 * TODO  测试接口，避免每次要写单元测试注解$
 *
 * @author sc
 * @date 2021/1/13
 */
@Target(ElementType.TYPE)
@Inherited
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public @interface SpringTest {
}
