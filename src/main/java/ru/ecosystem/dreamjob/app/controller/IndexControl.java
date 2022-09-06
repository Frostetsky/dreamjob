package ru.ecosystem.dreamjob.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexControl {

    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}