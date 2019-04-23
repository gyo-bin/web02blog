package kr.hs.dgsw.web02blog.Protocol;

import kr.hs.dgsw.web02blog.Domain.Post;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PostUserNameProtocol extends Post {
    private String name;

    public PostUserNameProtocol(Post post, String name) {
        super(post);
        this.name = name;
    }
}