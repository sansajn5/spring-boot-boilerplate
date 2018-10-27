package nucleus.it.orianna.configuration.security;

import nucleus.it.orianna.domain.User;
import nucleus.it.orianna.repository.UserRepository;
import nucleus.it.orianna.service.user.exception.UserNotActivated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;


/**
 * Authenticate a user from the database.
 * @author sansajn
 */
@Component
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    private final UserRepository userRepository;

    @Autowired
    public DomainUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String email) {
        Optional<User> userByUsernameFromDatabase = userRepository.findUserByEmail(email);
        return userByUsernameFromDatabase.map(user -> createSpringSecurityUser(user)).orElseThrow(() ->
                new UsernameNotFoundException("User " + email + " was not found in the " +
                        "database"));
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(User user)  {
//        if (!user.isActive())
//            throw new UserNotActivated(user.getEmail());

        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getHashPassword(),
                grantedAuthorities);
    }
}
