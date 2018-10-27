package nucleus.it.orianna.web.rest.auth.dto.response;

import nucleus.it.orianna.web.rest.user.dto.response.UserResponseDTO;

public class SignInResponseDTO {

    private UserResponseDTO user;
    private String token;

    SignInResponseDTO() {}

    public SignInResponseDTO(UserResponseDTO user, String token) {
        this.user = user;
        this.token = token;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
