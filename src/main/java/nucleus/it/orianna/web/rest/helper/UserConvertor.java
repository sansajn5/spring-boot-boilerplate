package nucleus.it.orianna.web.rest.helper;

import nucleus.it.orianna.domain.User;
import nucleus.it.orianna.web.rest.user.dto.response.UserResponseDTO;
import nucleus.it.orianna.web.rest.user.dto.response.UsersResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConvertor {

    public UserResponseDTO convertToUserResponse(User user) {
        return new UserResponseDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getLastName());
    }

    public UsersResponseDTO convertToUsersResponse(List<User> users) {
        return new UsersResponseDTO(users
                .stream()
                .map(user -> convertToUserResponse(user))
                .collect(Collectors.toList()), 0);
    }
}
