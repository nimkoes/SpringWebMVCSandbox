package me.nimkoes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyHelloController {

    @GetMapping("/hello/{id}")
    @ResponseBody
    public UserInfo hello(@PathVariable int id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);

        return userInfo;
    }

}
