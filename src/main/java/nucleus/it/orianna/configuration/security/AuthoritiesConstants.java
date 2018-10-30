package nucleus.it.orianna.configuration.security;

/**
 * Const values for authorization procces
 * @author sansajn
 */
public class AuthoritiesConstants {

    public static final String SUPER_ADMIN = "SUPER_ADMIN";

    public static final String ADMIN = "ADMIN";

    public static final String USER = "USER";

    public static final String ANONYMOUS = "ANONYMOUS";

    private static final String AUTH_ADMIN = "hasAuthority('ADMIN')";

    private static final String AUTH_USER = "hasAuthority('USER')";

    private AuthoritiesConstants() {

    }

}