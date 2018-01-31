package com.zsgwsjj.jiang.user.test;

import com.zsgwsjj.jiang.user.ctrl.UserAccCtrl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author : jiang
 * @time : 2018/01/30 22:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:context.xml"})
public class UserTest {

    @Autowired
    private UserAccCtrl userAccCtrl;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userAccCtrl).build();
    }

    @Before
    public void dbInit() {
        String createSql = "classpath:sql/create.sql";
        String initSql = "classpath:sql/init.sql";
        String insertSql = "classpath:sql/insert.sql";
        Resource resource = wac.getResource(createSql);
        JdbcTestUtils.executeSqlScript(jdbcTemplate, resource, true);
        Resource resource2 = wac.getResource(initSql);
        JdbcTestUtils.executeSqlScript(jdbcTemplate, resource2, true);
//        Resource resource3 = wac.getResource(insertSql);
//        JdbcTestUtils.executeSqlScript(jdbcTemplate, resource3, true);

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
