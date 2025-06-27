import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
       
        User user1 = new User(1L, "Alice");
        User user2 = new User(2L, "Bob");
        User user3 = new User(3L, "Alice");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

       
        List<User> result = userRepository.findByName("Alice");

        
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(u -> u.getName().equals("Alice")));
    }
}

