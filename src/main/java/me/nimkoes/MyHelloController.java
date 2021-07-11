package me.nimkoes;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHelloController {

    @GetHelloMapping
    public String hello() {
        return "hello";
    }

}
