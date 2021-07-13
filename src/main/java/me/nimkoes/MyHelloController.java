package me.nimkoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHelloController {

    @GetMapping
    @RequestMapping
    public String hello() {
        return "hello";
    }

}
