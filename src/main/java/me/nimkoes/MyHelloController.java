package me.nimkoes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class MyHelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @PostMapping
    @ResponseBody
    public String hi() {
        return "hi";
    }

}
