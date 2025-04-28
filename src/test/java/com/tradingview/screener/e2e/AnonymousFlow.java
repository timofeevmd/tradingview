package com.tradingview.screener.e2e;

import com.codeborne.selenide.SelenideElement;
import com.tradingview.screener.e2e.config.BasePage;
import com.tradingview.screener.enums.dropdown.MainUserMenu;
import com.tradingview.screener.modalwinow.HealCenterModalWindow;
import com.tradingview.screener.pages.ScreenerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AnonymousFlow extends BasePage {

    @Test(threadPoolSize = 1, invocationCount = 1, timeOut = 20000)
    public void anonymousUserHelpCenterSupportRequest(){
        List<SelenideElement> supportRequestElements = new ArrayList<>();
        List<String> expectedTextOfSupportRequestElements = List.of("Support requests", "Enhance your support experience");
        ScreenerPage screenerPage = new ScreenerPage();

        screenerPage.openUserMenuAnonymous()
                .anonymousUserMenu(MainUserMenu.HELP_CENTER);

        HealCenterModalWindow healCenterModalWindow = new HealCenterModalWindow();

        supportRequestElements = healCenterModalWindow.openSupportRequestModalWindow()
                .getElements();

        Assert.assertEquals(expectedTextOfSupportRequestElements.get(0),supportRequestElements.get(0).getText(), "header text is not equal");
        Assert.assertEquals(expectedTextOfSupportRequestElements.get(1),supportRequestElements.get(1).getText(), "state title text is not equal");
    }
}
