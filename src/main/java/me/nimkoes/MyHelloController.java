package me.nimkoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam("name") Person person) {
        System.out.println("handler method execute !!");
        return "hello " + person.getName();
    }

    @GetMapping("/message")
    public String message(@RequestBody String body) {
        return "Hello, " + body;
    }

    @GetMapping("/jsonMessage")
    public Person jsonMessage(@RequestBody Person person) {
        System.out.println(person.getName());
        person.setName("My name is " + person.getName());
        return person;
    }

}
