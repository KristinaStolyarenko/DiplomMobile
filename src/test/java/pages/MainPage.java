package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    public SelenideElement
            topListsScreenTitle = $(byText("Top Lists")),
            profileScreenTitle = $(byText("My Profile")),
            topChartsHeaderText = $(byText("Trending wines from the Vivino community")),
            welcomeScreenTitleText = $(byText("You’re almost done!")),
            welcomeScreenSubTitleText = $(byText("Make the most of the world’s largest wine community by completing these easy steps"));

    public ElementsCollection topChartsListHeader = $$(MobileBy.id("vivino.web.app:id/txtTopChartsIn"));

    public void checkTopChartsListHeaderTextWithRightUserCountry(String country) {
        topChartsListHeader.shouldHave(texts("Top Charts in " + country));
    }
}
