package helpers;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class BrowserStack {
    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    static String user = config.browserStackUser();
    static String key = config.browserStackKey();

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(user, key)
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}