package nucleus.it.orianna.service.auth;

import nucleus.it.orianna.configuration.security.DomainUserDetailsService;
import nucleus.it.orianna.domain.User;
import nucleus.it.orianna.repository.UserRepository;
import nucleus.it.orianna.service.auth.data.SignInData;
import nucleus.it.orianna.service.auth.exception.UsernameExists;
import nucleus.it.orianna.service.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SignIn {

    private final UserRepository userRepository;

    private final DomainUserDetailsService domainUserDetailsService;

    private final AuthenticationManager authenticationManager;


    @Autowired
    public SignIn(UserRepository userRepository, DomainUserDetailsService domainUserDetailsService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.domainUserDetailsService = domainUserDetailsService;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Method returning existing user from database
     *
     * @param signInData
     * @return
     * @throws UserNotFoundException
     */
    public User signIn(SignInData signInData) throws UserNotFoundException {
        domainUserDetailsService.loadUserByUsername(signInData.getEmail());
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                signInData.getEmail(), signInData.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return userRepository.findOneByEmail(signInData.getEmail());
    }

}
