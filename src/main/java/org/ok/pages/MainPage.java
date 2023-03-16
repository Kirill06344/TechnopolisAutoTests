package org.ok.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement NAVIGATION_ELEMENT = $x("//*[@class='navigation']");

    public void check() {
        NAVIGATION_ELEMENT.shouldBe(Condition.visible);
    }
}
