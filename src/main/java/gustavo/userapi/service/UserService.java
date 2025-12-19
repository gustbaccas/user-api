package gustavo.userapi.service;

import gustavo.userapi.entity.UserEntity;
import gustavo.userapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserEntity create(UserEntity user) {
        user.setActive(true);
        return repository.save(user);
    }

    public UserEntity findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    public UserEntity desactivate(Integer id) {
        UserEntity userDesactivate = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        userDesactivate.setActive(false);
        return repository.save(userDesactivate);
    }

    public void deleteById(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado!");
        }
        repository.deleteById(id);
    }
}
