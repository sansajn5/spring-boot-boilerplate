package nucleus.it.orianna.web.rest.auth;

import jdk.nashorn.internal.parser.Token;
import nucleus.it.orianna.domain.User;
import nucleus.it.orianna.service.auth.SignIn;
import nucleus.it.orianna.service.auth.SignUp;
import nucleus.it.orianna.service.auth.data.SignInData;
import nucleus.it.orianna.service.auth.data.SignUpData;
import nucleus.it.orianna.service.auth.exception.UsernameExists;
import nucleus.it.orianna.service.user.exception.UserNotFoundException;
import nucleus.it.orianna.util.TokenProvider;
import nucleus.it.orianna.web.rest.auth.dto.request.SignInDTO;
import nucleus.it.orianna.web.rest.auth.dto.response.SignInResponseDTO;
import nucleus.it.orianna.web.rest.helper.UserConvertor;
import nucleus.it.orianna.web.rest.user.dto.request.SignUpRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.xml.ws.Response;

@RestController
@RequestMapping("/api/auth")
public class AuthResource {

    private static final Logger logger = LoggerFactory.getLogger(AuthResource.class);

    private final SignUp signUp;

    private final SignIn signIn;

    private final TokenProvider tokenProvider;

    private final UserConvertor userConvertor;

    @Autowired
    public AuthResource(SignUp signUp, SignIn signIn, TokenProvider tokenProvider, UserConvertor userConvertor) {
        this.signUp = signUp;
        this.signIn = signIn;
        this.tokenProvider = tokenProvider;
        this.userConvertor = userConvertor;
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

    @PostMapping("/sign-in")
    public ResponseEntity<SignInResponseDTO> signIn(@RequestBody @Valid SignInDTO signInDTO) throws UserNotFoundException {
        logger.info("POST /api/auth/sign-in - {}", signInDTO);
        User user = signIn.signIn(new SignInData(signInDTO.getEmail(), signInDTO.getPassword()));
        String token = tokenProvider.generateToken(user);
        return new ResponseEntity<>(new SignInResponseDTO(this.userConvertor.convertToUserResponse(user), token), HttpStatus.OK);
    }

}
