package nucleus.it.orianna.web.rest.user.dto.response;

import java.util.List;

public class UsersResponseDTO {

    private List<UserResponseDTO> users;

    private int totalCount;

    public UsersResponseDTO() {

    }

    public UsersResponseDTO(List<UserResponseDTO> users, int totalCount) {
        this.users = users;
        this.totalCount = totalCount;
    }

    public List<UserResponseDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponseDTO> users) {
        this.users = users;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
