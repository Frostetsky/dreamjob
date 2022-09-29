package ru.ecosystem.dreamjob.app.repository;

import org.springframework.stereotype.Repository;
import ru.ecosystem.dreamjob.app.model.Candidate;
import ru.ecosystem.dreamjob.app.model.Post;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static ru.ecosystem.dreamjob.app.util.DreamJobUtils.*;

@Repository
public class CandidateRepository {

    private final Map<Long, Candidate> candidates = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        long firstPostId = generateId();
        long secondPostId = generateId();
        long thirdPostId = generateId();
        candidates.put(firstPostId, new Candidate(firstPostId, "Junior Java Developer", "150 000", "description", LocalDateTime.now()));
        candidates.put(secondPostId, new Candidate(secondPostId, "Middle Php Developer", "200 000", "description", LocalDateTime.now()));
        candidates.put(thirdPostId, new Candidate(thirdPostId, "Senior DevOps", "256 000", "description", LocalDateTime.now()));
    }

    public List<Candidate> findAll() {
        return new ArrayList<>(candidates.values());
    }

    public void addCandidate(Candidate candidate) {
        long id = generateId();
        candidate.setId(id);
        candidate.setCreated(LocalDateTime.now());
        candidates.putIfAbsent(id, candidate);
    }

    public Candidate getById(long id) {
        return candidates.get(id);
    }

    public void update(long id, Candidate candidate) {
        candidates.computeIfPresent(id, (idSaved, candidateUpdated) -> {
            candidateUpdated.setId(id);
            candidateUpdated.setCreated(candidateUpdated.getCreated());
            candidateUpdated.setName(candidate.getName());
            candidateUpdated.setPrice(candidate.getPrice());
            candidateUpdated.setDescription(candidate.getDescription());
            return candidateUpdated;
        });
    }
}
