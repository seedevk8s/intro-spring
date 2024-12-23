package com.intro.introspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IntroController {

    @GetMapping("intro")
    public String intro(Model model) {
        model.addAttribute("data", "Intro Spring!!");
        return "intro";
    }

    @GetMapping("intro-mvc")
    public String introMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
