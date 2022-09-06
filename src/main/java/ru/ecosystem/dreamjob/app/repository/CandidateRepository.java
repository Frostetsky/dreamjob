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

@Repository
public class CandidateRepository {

    private final Map<Integer, Candidate> posts = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        posts.put(1, new Candidate(1, "Junior Java Developer", "description", LocalDateTime.now()));
        posts.put(2, new Candidate(2, "Middle Php Developer", "description", LocalDateTime.now()));
        posts.put(3, new Candidate(3, "Senior DevOps", "description", LocalDateTime.now()));
    }

    public List<Candidate> findAll() {
        return new ArrayList<>(posts.values());
    }
}
