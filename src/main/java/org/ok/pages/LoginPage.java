package org.ok.pages;

import org.ok.utils.User;
import org.openqa.selenium.Keys;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class LoginPage implements LoadableComponent {

    private final SelenideElement EMAIL_FIELD = Selenide.$x("//*[@id='field_email']");

    private final SelenideElement PASSWORD_FIELD = Selenide.$x("//*[@id='field_password']");

    private final SelenideElement TRANSITION_BUTTON = Selenide.$x("//*[@class='button-pro __wide']");

    private final SelenideElement INCORRECT_DATA = Selenide.$x("//*[@class='input-e login_error']");

    public LoginPage open() {
        Selenide.open("https://ok.ru/");
        return this;
    }

    public LoginPage setUserData(User user) {
        EMAIL_FIELD.shouldBe(Condition.visible).setValue(user.getLogin());
        PASSWORD_FIELD.shouldBe(Condition.visible).setValue(user.getPassword());
        return this;
    }

    public MainPage enterWithClick() {
        TRANSITION_BUTTON.shouldBe(Condition.visible).click();
        return new MainPage();
    }

    public MainPage enterWithButton() {
        TRANSITION_BUTTON.shouldBe(Condition.visible).sendKeys(Keys.ENTER);
        return new MainPage();
    }

    public void isMessageWithIncorrectData() {
        INCORRECT_DATA.shouldBe(Condition.visible);
    }

    @Override
    public void checkExistense() {
        checkIsLoaded(EMAIL_FIELD);
        checkIsLoaded(PASSWORD_FIELD);
        checkIsLoaded(TRANSITION_BUTTON);
        checkIsLoaded(INCORRECT_DATA);
    }
}
