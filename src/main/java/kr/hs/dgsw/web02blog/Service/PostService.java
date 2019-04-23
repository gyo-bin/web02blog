package kr.hs.dgsw.web02blog.Service;

import kr.hs.dgsw.web02blog.Domain.Post;
import kr.hs.dgsw.web02blog.Protocol.PostUserNameProtocol;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<PostUserNameProtocol> get();

    Optional<Post> get(long id);

    Optional<PostUserNameProtocol> getWithName(long id);

    PostUserNameProtocol add(@NonNull Post post);

    Post update(@NonNull Post post);

    boolean delete(@NonNull Post post);

    boolean delete(long id);
}