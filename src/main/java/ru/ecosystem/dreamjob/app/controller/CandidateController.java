package ru.ecosystem.dreamjob.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.ecosystem.dreamjob.app.model.Candidate;
import ru.ecosystem.dreamjob.app.model.Post;
import ru.ecosystem.dreamjob.app.service.CandidateService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/candidates")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CandidateController {

    private final CandidateService candidateService;

    @GetMapping
    public ModelAndView getAllCandidates() {
        return new ModelAndView("candidates", Map.of("candidates", candidateService.getAllCandidates()));
    }

    @GetMapping("/addCandidate")
    public ModelAndView addPostForm() {
        return new ModelAndView(
                "add-candidate",
                Map.of("candidate", new Candidate()));
    }

    @PostMapping("/addCandidate")
    public void addPostSubmit(@ModelAttribute("candidate") Candidate candidate,
                              HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse) throws IOException {

        candidateService.addCandidate(candidate);
        httpServletResponse.sendRedirect(String.format("%s/candidates", httpServletRequest.getContextPath()));
    }
}
