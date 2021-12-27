package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:credentials.properties"})
public interface CredentialsConfig extends Config {
    String browserStackUser();
    String browserStackKey();
    String browserStackAppUrl();
    String selenoidUser();
    String selenoidPassword();
    String testUserLogin();
    String testUserPassword();
    String testUserCountry();
}