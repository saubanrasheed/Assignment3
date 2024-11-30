import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class LoginAppTest {


    private LoginApp loginApp;

    @BeforeEach
    void setUp() {
        loginApp = new LoginApp();
    }

    @Test
    void testSuccessfulLogin() throws Exception {
        // Test case: Valid email, user found in the database
        String testEmail = "johndoe@example.com";
        String expectedName = "John Doe";


            String actualName = loginApp.authenticateUser(testEmail);

            assertEquals(expectedName, actualName, "The username should match the database record.");


    }

    @Test
    void testFailedLogin() throws Exception {
        // Test case: Valid email, but user not found in the database
        String testEmail = "notfound@example.com";

            String actualName = loginApp.authenticateUser(testEmail);

            assertNull(actualName, "The username should be null if the user is not found.");

    }

    @Test
    void testInvalidEmail() throws Exception {
        // Test case: Invalid email format
        String testEmail = "invalid-email";

String actualName = loginApp.authenticateUser(testEmail);

            assertNull(actualName, "The username should be null for an invalid email format.");

    }

    @Test
    void testDatabaseConnectionError() throws Exception {
        // Test case: Database connection failure
        String testEmail = "user@example.com";

            String actualName = loginApp.authenticateUser(testEmail);

            assertNull(actualName, "The username should be null if there is a database connection error.");

    }

    @Test
    void testSQLInjectionAttempt() throws Exception {
        // Test case: SQL injection attempt
        String testEmail = "anything@example.com' OR '1'='1";

            String actualName = loginApp.authenticateUser(testEmail);

            assertNull(actualName, "The username should be null for a SQL injection attempt.");

    }
}