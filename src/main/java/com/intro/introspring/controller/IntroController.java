package com.intro.introspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IntroController {

    @GetMapping("intro")
    public String intro(Model model) {
        model.addAttribute("data", "Intro Spring!!");
        return "intro";
    }

    @GetMapping("intro-mvc")
    public String introMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("intro-string")
    @ResponseBody
    public String introString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("intro-api")
    @ResponseBody
    public Intro helloApi(@RequestParam("name") String name) {
        Intro intro = new Intro();
        intro.setName(name);
        return intro;
    }

    static class Intro {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
