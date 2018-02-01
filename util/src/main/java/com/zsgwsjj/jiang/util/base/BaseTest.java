package com.zsgwsjj.jiang.util.base;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author : jiang
 * @time : 2018/2/1 16:56
 */

public class BaseTest {

    @Autowired
    public WebApplicationContext wac;
    @Autowired
    public JdbcTemplate jdbcTemplate;

    protected MockMvc mockMvc;

    @Before
    public void setMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
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
        Resource resource3 = wac.getResource(insertSql);
        JdbcTestUtils.executeSqlScript(jdbcTemplate, resource3, true);
    }
}
