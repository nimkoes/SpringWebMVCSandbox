package me.nimkoes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.StringWriter;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.oxm.Marshaller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MyHelloControllerTest {

    // @WebMvcTest annotation 을 정의하면 MockMvc 를 주입받을 수 있다.
    @Autowired
    MockMvc mockMvc;

    // Spring Boot 를 사용하여 기본적으로 등록 된 bean 중 Jackson 이 제공하는 ObjectMapper 를 사용
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Marshaller marshaller;

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

    @Test
    public void stringMessage() throws Exception {
        this.mockMvc.perform(get("/message").content("nimkoes"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("Hello, nimkoes"));
    }

    @Test
    public void jsonMessage() throws Exception {

        Person person = new Person();
        person.setName("nimkoes");

        // 객체를 json 문자열로 변환
        String jsonString = objectMapper.writeValueAsString(person);

        this.mockMvc.perform(get("/jsonMessage")
                .contentType(MediaType.APPLICATION_JSON_UTF8)  // context type 을 사용하여 request 데이터가 json 형식임을 알려줌
                .accept(MediaType.APPLICATION_JSON_UTF8)       // accept 를 사용하여 response 데이터가 json 형식이기를 바란다고 알려줌
                .content(jsonString))                          // request body 에 jsonString 입력
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("My name is nimkoes"));
    }


    @Test
    public void xmlMessage() throws Exception {

        Person person = new Person();
        person.setName("nimkoes");

        // 객체를 xml 문자열로 변환
        StringWriter stringWriter = new StringWriter();
        Result result = new StreamResult(stringWriter);
        marshaller.marshal(person, result);

        String xmlString = stringWriter.toString();


        this.mockMvc.perform(get("/jsonMessage")
                .contentType(MediaType.APPLICATION_XML)  // context type 을 사용하여 request 데이터가 xml 형식임을 알려줌
                .accept(MediaType.APPLICATION_XML)       // accept 를 사용하여 response 데이터가 xml 형식이기를 바란다고 알려줌
                .content(xmlString))                     // request body 에 xmlString 입력
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(xpath("person/name").string("My name is nimkoes"));
    }
}