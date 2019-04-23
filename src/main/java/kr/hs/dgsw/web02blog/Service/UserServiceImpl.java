package kr.hs.dgsw.web02blog.Service;

import kr.hs.dgsw.web02blog.Domain.User;
import kr.hs.dgsw.web02blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(@NonNull UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> get() {
        return repository.findAll();
    }

    @Override
    public Optional<User> get(long id) {
        return repository.findById(id);
    }

    @Override
    public User add(@NonNull User user) {
        if (repository.existsById(user.getId())){
            return null;
        }else{
            return repository.save(user);
        }

    }

    @Override
    public User update(@NonNull User user) {
        return get(user.getId()).map(update -> {
            update.setEmail(Optional.ofNullable(user.getEmail()).orElse(update.getEmail()));
            update.setName(Optional.ofNullable(user.getName()).orElse(update.getName()));
            update.setPassword(Optional.ofNullable(user.getPassword()).orElse(update.getPassword()));
            update.setPhone(Optional.ofNullable(user.getPhone()).orElse(update.getPhone()));
            update.setProfilePath(Optional.ofNullable(user.getProfilePath()).orElse(update.getProfilePath()));
            return repository.save(update);
        }).orElse(null);
    }

    @Override
    public boolean delete(@NonNull User user) {
        return delete(user.getId());
    }

    @Override
    public boolean delete(long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}