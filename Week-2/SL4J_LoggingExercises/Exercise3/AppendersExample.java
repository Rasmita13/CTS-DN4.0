import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppendersExample {
    private static final Logger logger = LoggerFactory.getLogger(AppendersExample.class);

    public static void main(String[] args) {
        logger.info("This is an info message.");
        logger.warn("This is a warning.");
        logger.error("This is an error.");
    }
}

