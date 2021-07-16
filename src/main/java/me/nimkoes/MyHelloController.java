package me.nimkoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hi";
    }

}
