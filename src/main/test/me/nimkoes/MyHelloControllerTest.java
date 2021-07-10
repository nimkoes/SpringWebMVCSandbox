package me.nimkoes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MyHelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {

        mockMvc.perform(get("/hello")).andExpect(status().isOk());                 // 200
        mockMvc.perform(post("/hello")).andExpect(status().isMethodNotAllowed());  // 405
        mockMvc.perform(get("/hi")).andExpect(status().isNotFound());              // 404
        mockMvc.perform(post("/hi")).andExpect(status().isNotFound());             // 404

    }

}