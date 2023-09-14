package ginvent.backend.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ginvent.backend.users.entities.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        boolean exists = userRepository.existsByEmail(user.getEmail())
                || userRepository.existsByUsername(user.getUsername());

        if (exists) {
            return null;
        }
        return userRepository.save(user);
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public User update(String id, User user) {
        User oldUser = userRepository.findById(id).orElse(null);
        if (oldUser == null) {
            return null;
        }
        if (user.getEmail() != null) {
            oldUser.setEmail(user.getEmail());
        }
        if (user.getPassword() != null) {
            oldUser.setPassword(user.getPassword());
        }
        return userRepository.save(oldUser);
    }

    public User delete(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        userRepository.deleteById(id);
        return user;
    }

}
