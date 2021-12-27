package tests.local;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.OnboardingPage;

import static io.qameta.allure.Allure.step;

@Tag("local_android")
public class LocalAndroidSelenideTests extends LocalTestBase {
    OnboardingPage onboardingPage = new OnboardingPage();
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Onboarding - 'Try Us Out' flow")
    void tryUsOutOnboardingTest() {
        step("Start 'Try Us Out' onboarding", () -> {
            onboardingPage.startOnboardingScreenText.isDisplayed();
            onboardingPage.tryUsOutButton.click();
        });
        step("Check 'Try Us Out' onboarding screens", () -> {
            onboardingPage.checkOnboardingScreenText("Get honest wine ratings on any wine from our community of millions of wine drinkers");
            onboardingPage.checkOnboardingScreenText("Shop the world’s largest wine selection directly from your phone");
            onboardingPage.checkOnboardingScreenText("Scan any bottle to learn all about the wine inside");
            onboardingPage.checkOnboardingScreenText("Scan a restaurant wine list and choose your wine with confidence");
        });
        step("Check 'Try Us Out' onboarding is finished", () -> {
            onboardingPage.finalOnboardingScreenText.isDisplayed();
            onboardingPage.createFreeAccountButton.isDisplayed();
            onboardingPage.continueWithoutAccountButton.isDisplayed();
            onboardingPage.logInButton.isDisplayed();
        });
    }

    @Test
    @DisplayName("Onboarding - 'How It Works' flow")
    void howItWorksOnboardingTest() {
        step("Start 'How It Works' onboarding", () -> {
            onboardingPage.startOnboardingScreenText.isDisplayed();
            onboardingPage.howItWorksButton.click();
        });
        step("Check 'How It Works' onboarding screens", () -> {
            onboardingPage.checkOnboardingScreenText("Get honest wine ratings on any wine from our community of millions of wine drinkers");
            onboardingPage.checkOnboardingScreenText("Shop the world’s largest wine selection directly from your phone");
            onboardingPage.checkOnboardingScreenText("Scan any bottle to learn all about the wine inside");
            onboardingPage.checkOnboardingScreenText("Scan a restaurant wine list and choose your wine with confidence");
        });
        step("Check 'How It Works' onboarding is finished", () -> {
            onboardingPage.finalOnboardingScreenText.isDisplayed();
            onboardingPage.continueWithEmailButton.isDisplayed();
            onboardingPage.continueWithFacebookButton.isDisplayed();
            onboardingPage.continueWithGoogleButton.isDisplayed();
            onboardingPage.logInButton.isDisplayed();
        });
    }

    @Test
    @DisplayName("Successful start without account")
    void startWithoutAccountTest() {
        step("Start 'Try Us Out' onboarding", () -> {
            onboardingPage.startOnboardingScreenText.isDisplayed();
            onboardingPage.tryUsOutButton.click();
        });
        step("Go through 'Try Us Out' onboarding screens", () -> {
            onboardingPage.nextButton.click();
            onboardingPage.nextButton.click();
            onboardingPage.nextButton.click();
            onboardingPage.nextButton.click();
        });
        step("Tap 'Continue without account' button", () ->
            onboardingPage.continueWithoutAccountButton.click()
        );
        step("Check start without account is successful", () -> {
            mainPage.profileScreenTitle.isDisplayed();
            mainPage.welcomeScreenTitleText.isDisplayed();
            mainPage.welcomeScreenSubTitleText.isDisplayed();
        });
    }

    @Test
    @DisplayName("Successful login through 'I have an account'")
    void successfulLoginThroughIHaveAnAccountTest() {
        step("Go to 'I have an account' login screen", () -> {
            onboardingPage.startOnboardingScreenText.isDisplayed();
            onboardingPage.iHaveAnAccountButton.click();
        });
        step("Input login data", () -> {
            loginPage.logInScreenHeaderText.isDisplayed();
            loginPage.emailInput.sendKeys(testUserLogin);
            loginPage.passwordInput.sendKeys(testUserPassword);
        });
        step("Tap 'Log in' button", () ->
            loginPage.logInButton.click()
        );
        step("Check login is successful", () -> {
            mainPage.topListsScreenTitle.isDisplayed();
            mainPage.topChartsHeaderText.isDisplayed();
            mainPage.checkTopChartsListHeaderTextWithRightUserCountry(testUserCountry);
        });
    }

    @Test
    @DisplayName("Successful login through 'Get started'")
    void successfulLoginThroughGetStartedTest() {
        step("Go to 'Get started' registration screen", () -> {
            onboardingPage.startOnboardingScreenText.isDisplayed();
            onboardingPage.getStartedButton.click();
        });
        step("Input login data", () -> {
            loginPage.registrationScreenHeaderText.isDisplayed();
            loginPage.emailInput.sendKeys(testUserLogin);
            loginPage.passwordInput.sendKeys(testUserPassword);
        });
        step("Tap 'Next' button", () ->
            loginPage.registrationButton.click()
        );
        step("Check login is successful", () -> {
            mainPage.topListsScreenTitle.isDisplayed();
            mainPage.topChartsHeaderText.isDisplayed();
            mainPage.checkTopChartsListHeaderTextWithRightUserCountry(testUserCountry);
        });
    }
}