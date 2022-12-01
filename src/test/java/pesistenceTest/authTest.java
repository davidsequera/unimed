package pesistenceTest;

import com.unimed.persistence.auth.Auth;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class authTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "password", "other"})  // six numbers
    void testPasswordHashing(String password) {
        String hash = Auth.hashPassword(password);
        Assertions.assertTrue(Auth.verifyPassword(password, hash));
    }

}
