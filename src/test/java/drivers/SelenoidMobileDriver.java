package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.CredentialsConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidMobileDriver implements WebDriverProvider {

    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    static String user = config.selenoidUser();
    static String password = config.selenoidPassword();

    public static URL getSelenoidServerUrl() {
        try {
            return new URL("https://" + user + ":" + password + "@selenoid.autotests.cloud/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "android");
        desiredCapabilities.setCapability("version", "8.1");
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);
        desiredCapabilities.setCapability("appPackage", "vivino.web.app");
        desiredCapabilities.setCapability("appActivity", "com.sphinx_solution.Launcher");
        desiredCapabilities.setCapability("app", apkUrl());

        return new AndroidDriver(getSelenoidServerUrl(), desiredCapabilities);
    }

    private URL apkUrl() {
        try {
            return new URL("https://github.com/KristinaStolyarenko/DiplomMobile/raw/master/src/test/resources/Vivino%20Buy%20the%20Right%20Wine_v8.20.16_apkpure.com.apk");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}