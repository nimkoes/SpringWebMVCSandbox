package me.nimkoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHelloController {

    // GET /hello/2321;name=nimkoes

    @GetMapping("/hello/{id}")
    @ResponseBody
    public UserInfo hello(@PathVariable int id, @MatrixVariable String name) {

        // id == 2321
        // name == nimkoes

        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName(name);
        return userInfo;
    }

}
