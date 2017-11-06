package com.amayadream.sharding;

import com.amayadream.sharding.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author :  Amayadream
 * @date :  2017.11.06 22:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoServiceTest {

    @Resource
    private DemoService demoService;

    @Test
    public void demoTest() {
        demoService.demo();
    }

}
