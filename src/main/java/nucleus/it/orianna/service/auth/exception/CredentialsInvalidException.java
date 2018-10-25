package nucleus.it.orianna.service.auth.exception;

import nucleus.it.orianna.service.exception.CustomException;

public class CredentialsInvalidException extends CustomException {

    public CredentialsInvalidException() {
        super("credentials.invalid");
    }
}
