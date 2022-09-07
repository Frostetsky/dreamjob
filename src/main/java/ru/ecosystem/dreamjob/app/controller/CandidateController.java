package ru.ecosystem.dreamjob.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.ecosystem.dreamjob.app.service.CandidateService;

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
}
