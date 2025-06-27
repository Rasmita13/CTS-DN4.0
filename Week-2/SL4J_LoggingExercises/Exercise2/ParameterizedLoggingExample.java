import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String user = "Alice";
        int loginAttempts = 3;

        logger.info("User {} has attempted to log in {} times", user, loginAttempts);
        logger.debug("Debug log for user: {}", user);
        logger.error("Login failed for user {} after {} attempts", user, loginAttempts);
    }
}

