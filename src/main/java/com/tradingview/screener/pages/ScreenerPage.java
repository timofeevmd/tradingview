package com.tradingview.screener.pages;

import com.codeborne.selenide.SelenideElement;
import com.tradingview.screener.dropdowns.UserMenu;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ScreenerPage {

    private final String anonymous = "button[class*='user-menu-button--anonymous'] svg";
    private final String logged = "button[class*='user-menu-button--logged']";

    @Step("reopen anonymous menu")
    public UserMenu reopenUserMenuAnonymous() {
        getElement(anonymous).click();
        getElement(anonymous).click();
        return new UserMenu();
    }

    @Step("open anonymous menu")
    public UserMenu openUserMenuAnonymous(){
        getElement(anonymous).click();
        return new UserMenu();
    }

    @Step("open user menu as logged")
    public UserMenu openUserMenuLogged(){
        getElement(logged).click();
        return new UserMenu();
    }

    private SelenideElement getElement(String locator) {
        return $(locator).shouldBe(visible);
    }
}
