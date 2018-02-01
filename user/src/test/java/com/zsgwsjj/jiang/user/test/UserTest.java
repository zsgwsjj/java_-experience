package com.zsgwsjj.jiang.user.test;

import com.zsgwsjj.jiang.util.base.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * @author : jiang
 * @time : 2018/01/30 22:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:context.xml"})
public class UserTest extends BaseTest {

    @Test
    public void test() throws Exception {
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/login").param("username", "xx")
                .param("password", "e10adc3949ba59abbe56e057f20f883e")).andDo(MockMvcResultHandlers.print());
        MvcResult mvcResult = resultActions.andReturn();
        mvcResult.getResponse().getContentAsString();
    }

    @Test
    public void test2() throws Exception {
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/twitter/report")
                .param("uid", "1")
                .param("content", "this is test"))
                .andDo(MockMvcResultHandlers.print());
        MvcResult mvcResult = resultActions.andReturn();
        mvcResult.getResponse().getContentAsString();
    }

}
