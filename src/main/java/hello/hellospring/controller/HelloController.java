package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 웹 어플리케이션에서 첫번째 진입점이 Controller 이다.
@Controller
public class HelloController {

    // 웹 어플리케이션에서 /hello 로 들어오면 아래 메서드가 실행된다.
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!!"); // data는 model을 통해서 넘긴다.
        return "hello"; // resources/template/hello.html를 찾아서 랜더링하게 된다.
    }
}