package me.nimkoes;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyHelloController {

    @GetMapping(value = "/hello", headers = HttpHeaders.AUTHORIZATION + "=" + "4321")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/hi", headers = "!" + HttpHeaders.AUTHORIZATION)
    @ResponseBody
    public String hi() {
        return "hi";
    }

    @GetMapping(value = "/helloParam", params = "test")
    @ResponseBody
    public String helloParam() {
        return "hello";
    }

}
