package com.tradingview.screener.e2e;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.tradingview.screener.dropdowns.UserMenu;
import com.tradingview.screener.e2e.config.BasePage;
import com.tradingview.screener.enums.dropdown.MainUserMenu;
import com.tradingview.screener.modalwinow.SignInModalWindow;
import com.tradingview.screener.pages.ScreenerPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Epic("user authorization")
public class LoggedFlow extends BasePage {

    @Story("User can login via Email")
    @Severity(SeverityLevel.CRITICAL)
    @Description("The test checks the ability of a registered user to log in via email and password")
    @Test(threadPoolSize = 1, invocationCount = 1, timeOut = 20000)
    public void login(){
        List<SelenideElement> loggedUserMenuElements = new ArrayList<>();
        List<SelenideElement> anonymousUserMenuElements = new ArrayList<>();

        ScreenerPage screenerPage = new ScreenerPage();

        anonymousUserMenuElements = screenerPage
                .openUserMenuAnonymous()
                .getAnonymousUserElements();

        screenerPage.reopenUserMenuAnonymous()
                .anonymousUserMenu(MainUserMenu.SIGNIN);

        SignInModalWindow signInModalWindow = new SignInModalWindow();

        loggedUserMenuElements = signInModalWindow
                .emailSignIn()
                .setUserPassword()
                .signIn()
                .openUserMenuLogged()
                .getLoggedUserElements();

        Assert.assertNotEquals(loggedUserMenuElements.size(), anonymousUserMenuElements.size(), "The anonymous user menu and the logged in user menu should not have the same number of elements.");
        for (SelenideElement element : loggedUserMenuElements) {
            Assert.assertTrue(element.has(Condition.clickable), "Element should be clickable");
            Assert.assertTrue(element.has(Condition.visible), "Element should be visible");
        }

        UserMenu userMenu = new UserMenu();
        userMenu.loggedUserMenu(MainUserMenu.SIGN_OUT);
    }
}
