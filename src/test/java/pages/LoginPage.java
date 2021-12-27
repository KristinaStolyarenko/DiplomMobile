package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {
    public SelenideElement
            logInScreenHeaderText = $(byText("Welcome Back")),
            logInButton = $(MobileBy.id("vivino.web.app:id/action_signin")),
            registrationScreenHeaderText = $(byText("Create account")),
            registrationButton = $(MobileBy.id("vivino.web.app:id/action_next")),
            emailInput = $$(byClassName("android.widget.EditText")).get(0),
            passwordInput = $$(byClassName("android.widget.EditText")).get(1);
}
