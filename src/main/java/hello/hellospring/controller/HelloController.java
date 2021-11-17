package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//웹 어플리케이션에서 첫번째 진입점이 Controller 이다.
@Controller
public class HelloController {

    //웹 어플리케이션에서 /hello 로 들어오면 아래 메서드가 실행된다.
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!!"); // data는 model을 통해서 넘긴다.
        return "hello"; // resources/template/hello.html를 찾아서 랜더링하게 된다.
    }

    @GetMapping("hello-mvc")
    //command + P로 파라미터 옵션 볼수 있음 required를 false로 하면 파라미터 없어도 됨
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http의 body에 return 값을 직접 넣어주겠다.
    public String helloString(@RequestParam(value = "name") String name) {
        return "hello " + name; //반환값이 객체가 아니면 그냥 값 그대로 반환
    }

    @GetMapping("hello-api")
    @ResponseBody //ResponseBody를 사용하면 viewResolver 대신에 HttpMessageConverter가 동작함
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); // command + shift + enter 문장 자동 완성
        hello.setName(name);
        return hello; //반환값이 객체이면 json 방식으로 반환
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}