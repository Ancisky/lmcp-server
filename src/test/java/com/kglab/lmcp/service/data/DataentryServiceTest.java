package com.kglab.lmcp.service.data;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class DataentryServiceTest {

    @Autowired DataentryService dataentryService;
    @Test
    void saveOneSample() {
        dataentryService.SaveOneSample(null);
    }
}