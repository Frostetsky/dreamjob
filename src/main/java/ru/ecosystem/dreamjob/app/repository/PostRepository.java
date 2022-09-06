package ru.ecosystem.dreamjob.app.repository;

import org.springframework.stereotype.Repository;
import ru.ecosystem.dreamjob.app.model.Post;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class PostRepository {

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        posts.put(1, new Post(1, "Junior Java Developer", "description", LocalDateTime.now()));
        posts.put(2, new Post(2, "Middle Java Developer", "description", LocalDateTime.now()));
        posts.put(3, new Post(3, "Senior Java Developer", "description", LocalDateTime.now()));
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }



}
