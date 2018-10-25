package nucleus.it.orianna.service.user.exception;

import nucleus.it.orianna.service.exception.CustomException;

public class UserNotFoundException extends CustomException {

    public UserNotFoundException() {
        super("user.not.found");
    }
}
