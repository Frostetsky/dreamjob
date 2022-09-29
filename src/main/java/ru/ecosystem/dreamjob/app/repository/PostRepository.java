package ru.ecosystem.dreamjob.app.repository;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.ecosystem.dreamjob.app.model.Post;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import static ru.ecosystem.dreamjob.app.util.DreamJobUtils.*;

@Repository
@ThreadSafe
public class PostRepository {

    private final Map<Long, Post> posts = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        long firstPostId = generateId();
        long secondPostId = generateId();
        long thirdPostId = generateId();
        posts.put(firstPostId, new Post(firstPostId, "Junior Java Developer", "company", "description", LocalDateTime.now()));
        posts.put(secondPostId, new Post(secondPostId, "Middle Java Developer", "company", "description", LocalDateTime.now()));
        posts.put(thirdPostId, new Post(thirdPostId, "Senior Java Developer", "company", "description", LocalDateTime.now()));
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    public void add(Post post) {
        long id = generateId();
        post.setId(id);
        post.setCreated(LocalDateTime.now());
        posts.putIfAbsent(id, post);
    }

    public void update(long id, Post post) {
        posts.computeIfPresent(id, (idSaved, postUpdated) -> {
            postUpdated.setId(id);
            postUpdated.setCreated(postUpdated.getCreated());
            postUpdated.setCompany(post.getCompany());
            postUpdated.setName(post.getName());
            postUpdated.setDescription(post.getDescription());
            return postUpdated;
        });
    }

    public Post getById(long id) {
        return posts.get(id);
    }
}
