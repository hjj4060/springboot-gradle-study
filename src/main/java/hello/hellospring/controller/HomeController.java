package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //index.html 보다 스프링컨테이너에서 먼저 찾기 때문에 index.html은 무시됨
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
