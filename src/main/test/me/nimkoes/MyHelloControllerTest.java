package me.nimkoes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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

        mockMvc.perform(get("/hello1"))                    .andExpect(content().string("hello case 1"));
        mockMvc.perform(get("/hello!"))                    .andExpect(content().string("hello case 1"));
        mockMvc.perform(get("/hello/z"))                   .andExpect(content().string("hello case 2"));
        mockMvc.perform(get("/hello/nk"))                  .andExpect(content().string("hello case 3"));
        mockMvc.perform(get("/hello/n/k"))                 .andExpect(content().string("hello case 4"));
        mockMvc.perform(get("/hello"))                     .andExpect(content().string("hello case 5"));
        mockMvc.perform(get("/helloTest"))                 .andExpect(content().string("hello case 5"));
        mockMvc.perform(get("/hello/nimkoes/test"))        .andExpect(content().string("hello case 6"));
        mockMvc.perform(get("/hello/nk/te_some_st"))       .andExpect(content().string("hello case 7"));
        mockMvc.perform(get("/hello/nk/some"))             .andExpect(content().string("hello case 8"));
        mockMvc.perform(get("/hello/nk/some/another"))     .andExpect(content().string("hello case 8"));
        mockMvc.perform(get("/hello/nk/some/another/test")).andExpect(content().string("hello case 9"));

    }

}