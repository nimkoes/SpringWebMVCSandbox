package me.nimkoes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MyHelloControllerTest {

    // @WebMvcTest annotation 을 정의하면 MockMvc 를 주입받을 수 있다.
    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        this.mockMvc.perform(get("/hello")
                .param("name", "nimkoes"))
            .andDo(print())
            .andExpect(content().string("hello nimkoes"));
    }

    @Test
    public void staticTest() throws Exception {
        this.mockMvc.perform(get("/index.html"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(Matchers.containsString("Hello Nimkoes")));
    }

    @Test
    public void staticTest_M() throws Exception {
        this.mockMvc.perform(get("/m/index.html"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(Matchers.containsString("Hello Mobile Nimkoes")))
            .andExpect(header().exists(HttpHeaders.CACHE_CONTROL));
    }
}