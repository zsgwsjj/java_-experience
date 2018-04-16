import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

/**
 * @author : jiang
 * @time : 2018/3/22 14:15
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:demo2.xml"})
public class AopTest  {
    public WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void baseTest() throws Exception {
        MockHttpServletRequestBuilder request;
        request = MockMvcRequestBuilders.post("/echo");
        ResultActions resultActions = mockMvc.perform(request).andDo(MockMvcResultHandlers.print());
        MvcResult mvcResult = resultActions.andReturn();
        mvcResult.getResponse().getContentAsString();
    }
}
