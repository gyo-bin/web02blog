package kr.hs.dgsw.web02blog.Service;

import kr.hs.dgsw.web02blog.Domain.Post;
import kr.hs.dgsw.web02blog.Domain.User;
import kr.hs.dgsw.web02blog.Protocol.PostUserNameProtocol;
import kr.hs.dgsw.web02blog.Repository.PostRepository;
import kr.hs.dgsw.web02blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository repository;
    private UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public List<PostUserNameProtocol> get() {
        List<Post> posts = repository.findAll();
        List<PostUserNameProtocol> protocols = new ArrayList<>();
        posts.forEach(post -> {
            protocols.add(new PostUserNameProtocol(post, userRepository.findById(post.getUserId()).map(User::getName).orElse(null)));
        });

        return protocols;
    }

    @Override
    public Optional<Post> get(long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<PostUserNameProtocol> getWithName(long id) {
        return repository.findById(id).map(post -> new PostUserNameProtocol(post, userRepository.findById(post.getUserId()).map(User::getName).orElse(null)));
    }

    @Override
    public PostUserNameProtocol add(Post post) {
        if (repository.existsById(post.getUserId()))
            return null;

        return new PostUserNameProtocol(repository.save(post), userRepository.findById(post.getUserId()).map(User::getName).orElse(null));
    }

    @Override
    public Post update(Post post) {
        return get(post.getId()).map(update -> {
            update.setContent(Optional.ofNullable(post.getContent()).orElse(update.getContent()));
            update.setPath(Optional.ofNullable(post.getPath()).orElse(update.getPath()));
            update.setName(Optional.ofNullable(post.getName()).orElse(update.getName()));
            return repository.save(update);
        }).orElse(null);
    }

    @Override
    public boolean delete(Post post) {
        return delete(post.getId());
    }

    @Override
    public boolean delete(long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}