package me.nimkoes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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

}