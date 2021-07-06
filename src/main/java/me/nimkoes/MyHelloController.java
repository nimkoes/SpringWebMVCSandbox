package me.nimkoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam("name") Person person) {
        System.out.println("handler method execute !!");
        return "hello " + person.getName();
    }

}
