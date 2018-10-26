package nucleus.it.orianna.service.user.exception;

import nucleus.it.orianna.util.ResourceBundleUtil;

import javax.naming.AuthenticationException;
import java.util.Locale;

public class UserNotActivated extends IllegalArgumentException {

    public UserNotActivated(String user) {
        super(user + ResourceBundleUtil.getExceptionValue( Locale.ENGLISH, "user.not.active"));
    }

}
