package ru.ecosystem.dreamjob.app.service;

import lombok.RequiredArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ecosystem.dreamjob.app.model.Candidate;
import ru.ecosystem.dreamjob.app.repository.CandidateRepository;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public void addCandidate(Candidate candidate) {
        candidateRepository.addCandidate(candidate);
    }

    public Candidate getCandidateById(long id) {
        return candidateRepository.getById(id);
    }

    public void updateCandidate(long id, Candidate candidate) {
        candidateRepository.update(id, candidate);
    }
}
