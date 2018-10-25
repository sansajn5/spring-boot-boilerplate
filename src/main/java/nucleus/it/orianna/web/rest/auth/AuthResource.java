package nucleus.it.orianna.web.rest.auth;

import nucleus.it.orianna.service.auth.SignUp;
import nucleus.it.orianna.service.auth.data.SignUpData;
import nucleus.it.orianna.service.auth.exception.UsernameExists;
import nucleus.it.orianna.web.rest.user.dto.request.SignUpRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthResource {

    private static final Logger logger = LoggerFactory.getLogger(AuthResource.class);

    private final SignUp signUp;

    @Autowired
    public AuthResource(SignUp signUp) {
        this.signUp = signUp;
    }

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody @Valid SignUpRequestDTO signUpRequestDTO) throws UsernameExists {
        logger.info("POST /api/auth/sign-up - {}", signUpRequestDTO);
        signUp.signUp(new SignUpData(
                signUpRequestDTO.getFirstName(),
                signUpRequestDTO.getLastName(),
                signUpRequestDTO.getEmail(),
                signUpRequestDTO.getPassword()
        ));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
