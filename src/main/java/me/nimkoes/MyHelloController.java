package me.nimkoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHelloController {

    @GetMapping("/hello?")
    public String hello_case_1() { return "hello case 1"; }

    @GetMapping("/hello/?")
    public String hello_case_2() { return "hello case 2"; }

    @GetMapping("/hello/??")
    public String hello_case_3() { return "hello case 3"; }

    @GetMapping("/hello/?/?")
    public String hello_case_4() { return "hello case 4"; }

    @GetMapping("/hello*")
    public String hello_case_5() { return "hello case 5"; }

    @GetMapping("/hello/*/test")
    public String hello_case_6() { return "hello case 6"; }

    @GetMapping("/hello/*/te*st")
    public String hello_case_7() { return "hello case 7"; }

    @GetMapping("/hello/**")
    public String hello_case_8() { return "hello case 8"; }

    @GetMapping("/hello/**/test")
    public String hello_case_9() { return "hello case 9"; }

}
