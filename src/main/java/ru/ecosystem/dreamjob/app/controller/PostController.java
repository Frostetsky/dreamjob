package ru.ecosystem.dreamjob.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.ecosystem.dreamjob.app.service.PostService;

import java.util.Map;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PostController {

    private final PostService postService;

    @GetMapping
    public ModelAndView getAllPosts() {
        return new ModelAndView("posts", Map.of("posts", postService.getAllPosts()));
    }
}