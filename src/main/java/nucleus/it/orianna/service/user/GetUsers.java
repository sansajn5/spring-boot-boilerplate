package nucleus.it.orianna.service.user;

import nucleus.it.orianna.domain.User;
import nucleus.it.orianna.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GetUsers {

    private final UserRepository userRepository;

    @Autowired
    public GetUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
}
