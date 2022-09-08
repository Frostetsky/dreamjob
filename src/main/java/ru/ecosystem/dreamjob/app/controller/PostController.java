package ru.ecosystem.dreamjob.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import ru.ecosystem.dreamjob.app.model.Post;
import ru.ecosystem.dreamjob.app.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @GetMapping("/addPost")
    public ModelAndView addPostForm() {
        return new ModelAndView(
                "add-post",
                Map.of("post", new Post()));
    }

    @PostMapping("/addPost")
    public void addPostSubmit(@ModelAttribute("post") Post post,
                              HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse) throws IOException {

        postService.addPost(post);
        httpServletResponse.sendRedirect(String.format("%s/posts", httpServletRequest.getContextPath()));
    }
}