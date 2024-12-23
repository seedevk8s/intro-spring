package com.intro.introspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {

    @GetMapping("intro")
    public String intro(Model model) {
        model.addAttribute("data", "Intro Spring!!");
        return "intro";
    }
}
