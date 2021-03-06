package tests;

import com.codeborne.selenide.Configuration;
import drivers.BrowserStackMobileDriver;
import drivers.LocalMobileDriver;
import drivers.SelenoidMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.getSessionId;

public class TestBase extends TestData {

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        switch (System.getProperty("deviceFarm")) {
            case "browserStack":
                Configuration.browser = BrowserStackMobileDriver.class.getName();
                break;
            case "selenoid":
                Configuration.browser = SelenoidMobileDriver.class.getName();
                break;
            case "local":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            default:
                Configuration.browser = BrowserStackMobileDriver.class.getName();
                break;
        }

        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        closeWebDriver();

        if (System.getProperty("deviceFarm") != "local") {
            Attach.attachVideo(sessionId);
        }
    }
}
