package kr.hs.dgsw.web02blog.Controller;

import kr.hs.dgsw.web02blog.Domain.Post;
import kr.hs.dgsw.web02blog.Protocol.PostUserNameProtocol;
import kr.hs.dgsw.web02blog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private PostService postservice;

    @Autowired
    public PostController(PostService service) {
        this.postservice = service;
    }

    @GetMapping("/post")
    public List<PostUserNameProtocol> get() {
        return postservice.get();
    }

    @GetMapping("/post/{id}")
    public PostUserNameProtocol get(@PathVariable long id) {
        return postservice.getWithName(id).orElse(null);
    }

    @PostMapping("/post")
    public PostUserNameProtocol add(@RequestBody Post post) {
        return postservice.add(post);
    }

    @PutMapping("/post")
    public Post update(@RequestBody Post post) {
        return postservice.update(post);
    }

    @DeleteMapping("/post")
    public boolean delete(@RequestBody Post post) {
        return postservice.delete(post);
    }

    @DeleteMapping("/post/{id}")
    public boolean delete(@PathVariable long id) {
        return postservice.delete(id);
    }
}