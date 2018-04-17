package spider1;

import com.zsgwsjj.jiang.spider1.dao.IResourcesDao;
import com.zsgwsjj.jiang.util.filter.AuthFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : jiang
 * @time : 2018/4/11 17:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:context.xml"})
public class SpiderTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private AuthFilter authFilter;

    @Before
    public void setMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).addFilter(authFilter).build();
    }

    @Autowired
    public IResourcesDao resourcesDao;

    @Test
    public void test() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("username", "jiang");
        params.put("password", "123456");
        MockHttpServletRequestBuilder request;
        request = MockMvcRequestBuilders.post("/spider/check");
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            request = request.param(entry.getKey(), String.valueOf(entry.getValue()));
        }
        ResultActions resultActions = mockMvc.perform(request).andDo(MockMvcResultHandlers.print());
        MvcResult mvcResult = resultActions.andReturn();
        mvcResult.getResponse().getContentAsString();
        MvcResult mvcResult2 = resultActions.andReturn();
        mvcResult2.getResponse().getContentAsString();
    }


}


