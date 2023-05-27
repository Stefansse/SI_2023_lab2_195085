import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testFunctionValidUser() {

        User user = new User("sfnn", "1#34567812", "sfnn.stosevski@gmail.com");
        List<User> allUsers = new ArrayList<>(5);


        boolean result = SILab2.function(user, allUsers);


        Assertions.assertTrue(result);
    }

    @Test
    void testFunctionNullUser() {

        User user = null;
        List<User> allUsers = new ArrayList<>();
        RuntimeException exception;


        exception = Assertions.assertThrows(RuntimeException.class, () -> {
            SILab2.function(user, allUsers);
        });
        Assertions.assertTrue(exception.getMessage().contains("Mandatory information missing!"));
    }

    @Test
    void testFunctionMissingPassword() {

        User user = new User("sfnn", null, "sfnn.stoshevski@gmail.com");
        List<User> allUsers = new ArrayList<>();


        Assertions.assertThrows(RuntimeException.class, () -> {
            SILab2.function(user, allUsers);
        });
    }

    @Test
    void testFunctionMissingEmail() {

        User user = new User("sfnn", "12345678", null);
        List<User> allUsers = new ArrayList<>(4);


        Assertions.assertThrows(RuntimeException.class, () -> {
            SILab2.function(user, allUsers);
        });
    }

    @Test
    void testFunctionUsernameIsNull() {
    
        User user = new User(null, "Password123", "john@example.com");
        List<User> allUsers = new ArrayList<>();

        
        boolean result = SILab2.function(user, allUsers);

        
        assertEquals(user.getEmail(), user.getUsername());
        assertTrue(result);
    }






    @Test
    void testFunctionPasswordContainsUsername() {

        User user = new User("sfnn134", "123456789", "sfnn.stoshevski@gmail.com");
        List<User> allUsers = new ArrayList<>(3);


        boolean result = SILab2.function(user, allUsers);


        Assertions.assertFalse(result);
    }

    @Test
    void testPasswordContainsSpace() {
        User user = new User("sfnn", "12 3456789", "sfnn.stoshevski@gmail.com");
        List<User> allUsers = new ArrayList<>();

        boolean result = SILab2.function(user, allUsers);

        Assertions.assertFalse(result);
    }


}
