package nucleus.it.orianna.service.auth;


import nucleus.it.orianna.domain.User;
import nucleus.it.orianna.repository.UserRepository;
import nucleus.it.orianna.service.auth.data.SignUpData;
import nucleus.it.orianna.service.auth.exception.UsernameExists;
import nucleus.it.orianna.service.user.CreateUser;
import nucleus.it.orianna.service.user.data.CreateUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUp {

    private final UserRepository userRepository;
    private final CreateUser createUser;

    @Autowired
    public SignUp(UserRepository userRepository, CreateUser createUser) {
        this.userRepository = userRepository;
        this.createUser = createUser;
    }

    public void signUp(SignUpData signUpData) throws UsernameExists {
        checkUserExistsByEmail(signUpData.getEmail());

        User user = createUser.createUser(new CreateUserData(
                signUpData.getFirstName(),
                signUpData.getLastName(),
                signUpData.getEmail(),
                signUpData.getPassword())
        );
    }

    private void checkUserExistsByEmail(String email) throws UsernameExists {
        if (userRepository.findUserByEmail(email).isPresent()) {
            throw new UsernameExists();
        }
    }
}
