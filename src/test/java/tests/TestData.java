package tests;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

public class TestData {
    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    public static String
        testUserLogin = config.testUserLogin(),
        testUserPassword = config.testUserPassword(),
        testUserCountry = config.testUserCountry();
}
