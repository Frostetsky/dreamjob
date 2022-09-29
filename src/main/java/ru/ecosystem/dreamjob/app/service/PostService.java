package ru.ecosystem.dreamjob.app.service;

import lombok.RequiredArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ecosystem.dreamjob.app.model.Post;
import ru.ecosystem.dreamjob.app.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@ThreadSafe
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void addPost(Post post) {
        postRepository.add(post);
    }

    public Post getPostById(long id) {
        return postRepository.getById(id);
    }

    public void updatePost(long id, Post post) {
        postRepository.update(id, post);
    }
}
