package me.nimkoes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MyHelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {

        mockMvc.perform(
                get("/hello")
                .header(HttpHeaders.AUTHORIZATION,"4321")
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("hello"))
        ;

        mockMvc.perform(
                get("/hi")
                .header(HttpHeaders.AUTHORIZATION,"1234")
            )
            .andDo(print())
            .andExpect(status().isNotFound())
        ;

        mockMvc.perform(get("/hi"))
            .andDo(print())
            .andExpect(status().isOk())
        ;

        mockMvc.perform(
                get("/helloParam")
                .param("test", "1234")
            )
            .andDo(print())
            .andExpect(status().isOk())
        ;

    }

}