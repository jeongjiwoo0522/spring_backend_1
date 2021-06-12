package com.example.awsomeproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("data", name);
        return "hello";
    }

    @GetMapping("hello-spring")
    @ResponseBody // http response body에 return 값을 넣어준다
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    /*
    *  @ResponeBody의 동작방식
    *  HttpMessageConverter에서 값을 처리
    *  문자열일 경우 StringConverter가 동작: body에 문자열을 담아 응답
    *  객체일 경우 JsonConverter가 동작: 객체를 json으로 바꿔 응답
    **/

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    public static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
