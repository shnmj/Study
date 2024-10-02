package com.example.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {


    @GetMapping("/temp/home")
    public String tempHome() {
        System.out.println("tempHome()");
        return "/home.html";
    }

    @GetMapping("/temp/jsp")
    public String tempJsp() {
        // prefix : /WEB-INF/views/
        // suffix : .jsp
        return "test";
    }
}
