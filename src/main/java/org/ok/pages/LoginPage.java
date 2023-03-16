package org.ok.pages;

import org.ok.utils.User;
import org.openqa.selenium.Keys;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class LoginPage {

    private final SelenideElement EMAIL_FIELD = Selenide.$x("//*[@id='field_email']");

    private final SelenideElement PASSWORD_FIELD = Selenide.$x("//*[@id='field_password']");

    private final SelenideElement TRANSITION_BUTTON = Selenide.$x("//*[@class='button-pro __wide']");

    private final SelenideElement INCORRECT_DATA = Selenide.$x("//*[@class='input-e login_error']");
    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public LoginPage setUserData(User user) {
        EMAIL_FIELD.shouldBe(Condition.visible).setValue(user.getLogin());
        PASSWORD_FIELD.shouldBe(Condition.visible).setValue(user.getPassword());
        return this;
    }

    public LoginPage enterWithClick() {
        TRANSITION_BUTTON.shouldBe(Condition.visible).click();
        return this;
    }

    public LoginPage enterWithButton() {
        TRANSITION_BUTTON.shouldBe(Condition.visible).sendKeys(Keys.ENTER);
        return this;
    }

    public void isMessageWithIncorrectData() {
        INCORRECT_DATA.shouldBe(Condition.visible);
    }

}
