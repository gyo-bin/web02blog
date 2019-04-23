package kr.hs.dgsw.web02blog.Service;

import kr.hs.dgsw.web02blog.Domain.User;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> get();

    Optional<User> get(long id);

    User add(@NonNull User user);

    User update(@NonNull User user);

    boolean delete(@NonNull User user);

    boolean delete(long id);
}