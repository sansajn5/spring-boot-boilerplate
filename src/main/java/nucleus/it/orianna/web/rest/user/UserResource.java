package nucleus.it.orianna.web.rest.user;

import nucleus.it.orianna.service.user.GetUsers;
import nucleus.it.orianna.web.rest.helper.UserConvertor;
import nucleus.it.orianna.web.rest.user.dto.response.UsersResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserResource {

    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

    private final GetUsers getUsers;

    private final UserConvertor userConvertor;

    @Autowired
    public UserResource(GetUsers getUsers, UserConvertor userConvertor) {
        this.getUsers = getUsers;
        this.userConvertor = userConvertor;
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<UsersResponseDTO> getUsers() {
        logger.info("GET /api/users");
        return new ResponseEntity<>(this.userConvertor.convertToUsersResponse(getUsers.getUsers()), HttpStatus.OK);
    }

}
