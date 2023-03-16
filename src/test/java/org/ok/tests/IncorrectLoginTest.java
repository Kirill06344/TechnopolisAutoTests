package org.ok.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.ok.pages.LoginPage;
import org.ok.utils.SupportFunctions;
import org.ok.utils.User;

public class IncorrectLoginTest extends BaseTest {

    LoginPage loginPage;

    User user;

    @BeforeAll
    public void initializeLoginPage() {
        loginPage = new LoginPage();
        user = new User("blsblsbsl", "blalblala");
    }

    @Test
    public void incorrectLoginWithClick() {
        SupportFunctions.login(loginPage, user);
        loginPage.enterWithClick();
        loginPage.isMessageWithIncorrectData();
    }

    @Test
    public void incorrectLoginDataWithKey() {
        SupportFunctions.login(loginPage, user);
        loginPage.enterWithButton();
        loginPage.isMessageWithIncorrectData();
    }

}
