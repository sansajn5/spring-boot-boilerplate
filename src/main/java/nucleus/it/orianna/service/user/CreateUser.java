package nucleus.it.orianna.service.user;

import nucleus.it.orianna.domain.User;
import nucleus.it.orianna.repository.UserRepository;
import nucleus.it.orianna.service.user.data.CreateUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class CreateUser {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public CreateUser(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public User createUser(CreateUserData createUserData) {
        User user = new User();
        user.setFirstName(createUserData.getFirstName());
        user.setLastName(createUserData.getLastName());
        user.setEmail(createUserData.getEmail().toLowerCase());
        user.setHashPassword(passwordEncoder.encode(createUserData.getPassword()));
        user.setDeleted(false);
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }
}
