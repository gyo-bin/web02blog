package kr.hs.dgsw.web02blog.Domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, updatable = false)
    private long userId;

    @Column(nullable = false)
    private String content;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String Path;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Attachment> pictures;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime updated;

    public Post(Post post) {
        this.id = post.id;
        this.userId = post.userId;
        this.content = post.content;
        this.Path = post.Path;
        this.name = post.name;
        this.created = post.created;
        this.updated = post.updated;
    }
}