package nucleus.it.orianna.service.auth.exception;

import nucleus.it.orianna.service.exception.CustomException;

public class UsernameExists extends CustomException {

    public UsernameExists() {
        super("email.exists");
    }
}
