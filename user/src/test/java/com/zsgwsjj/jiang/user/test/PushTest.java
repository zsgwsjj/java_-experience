package com.zsgwsjj.jiang.user.test;

import com.zsgwsjj.jiang.user.ctrl.UserAccCtrl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author : jiang
 * @time : 2018/01/30 22:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml"})
public class PushTest {

    @Autowired
    private UserAccCtrl userAccCtrl;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userAccCtrl).build();
    }

    @Test
    public void test() throws Exception {
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/login").param("username", "jiang")
                .param("password", "123456"));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result:" + result);
    }
}
