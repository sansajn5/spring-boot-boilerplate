package nucleus.it.orianna.web.rest.user;

import nucleus.it.orianna.domain.User;
import nucleus.it.orianna.service.user.GetUsers;
import nucleus.it.orianna.web.rest.user.dto.response.UserResponseDTO;
import nucleus.it.orianna.web.rest.user.dto.response.UsersResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

    private final GetUsers getUsers;

    @Autowired
    public UserResource(GetUsers getUsers) {
        this.getUsers = getUsers;
    }

    @GetMapping()
    public ResponseEntity<UsersResponseDTO> getUsers() {
        logger.info("GET /api/users");
        return new ResponseEntity<>(convertToUsersResponse(getUsers.getUsers()), HttpStatus.OK);
    }

    private UserResponseDTO convertToUserResponse(User user) {
        return new UserResponseDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getLastName());
    }

    private UsersResponseDTO convertToUsersResponse(List<User> users) {
        return new UsersResponseDTO(users
                .stream()
                .map(user -> convertToUserResponse(user))
                .collect(Collectors.toList()), 0);
    }
}
