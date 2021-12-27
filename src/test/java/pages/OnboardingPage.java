package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OnboardingPage {
    public SelenideElement
            startOnboardingScreenText = $(byText("With Vivino you can find and buy the right wine")),
            finalOnboardingScreenText = $(byText("Create a free account to save your wine scans, forever")),
            nextButton = $(MobileBy.id("vivino.web.app:id/next")),
            tryUsOutButton = $(MobileBy.id("vivino.web.app:id/txtTryUsOut")),
            howItWorksButton = $(MobileBy.id("vivino.web.app:id/seehowitwork")),
            iHaveAnAccountButton = $(MobileBy.id("vivino.web.app:id/txthaveaccount")),
            getStartedButton = $(MobileBy.id("vivino.web.app:id/getstarted_layout")),
            createFreeAccountButton = $(MobileBy.id("vivino.web.app:id/create_free_account")),
            continueWithoutAccountButton = $(MobileBy.id("vivino.web.app:id/continue_without_account")),
            continueWithEmailButton = $(MobileBy.id("vivino.web.app:id/continue_with_email")),
            continueWithFacebookButton = $(MobileBy.id("vivino.web.app:id/continue_with_facebook")),
            continueWithGoogleButton = $(MobileBy.id("vivino.web.app:id/continue_with_google")),
            logInButton = $(MobileBy.id("vivino.web.app:id/txtIHaveAnAccount"));

    public ElementsCollection onboardingScreenTextBlock = $$(MobileBy.id("vivino.web.app:id/description"));

    public void checkOnboardingScreenText(String text) {
        onboardingScreenTextBlock.shouldHave(texts(text));
        nextButton.click();
    }
}
