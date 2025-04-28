package com.tradingview.screener.dropdowns;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.tradingview.screener.enums.dropdown.LanguageDropDown;
import com.tradingview.screener.enums.dropdown.MainUserMenu;
import com.tradingview.screener.modalwinow.HealCenterModalWindow;
import com.tradingview.screener.modalwinow.ReferAFriendModalWindow;
import com.tradingview.screener.modalwinow.SignInModalWindow;
import com.tradingview.screener.modalwinow.WhatsNewModalWindow;
import com.tradingview.screener.pages.ScreenerPage;
import com.tradingview.screener.pages.profilePages.ProfilePage;
import com.tradingview.screener.pages.profilePages.pageFragment.AccountAndBuildingPageFragment;
import com.tradingview.screener.pages.profilePages.pageFragment.ProfileSettingsPageFragment;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class UserMenu {

    @Step("chose anonymous user menu option")
    public Object anonymousUserMenu (MainUserMenu option) {
        switch (option.name()){
            case "SIGNIN" :
                openMenuItem(option);
                return new SignInModalWindow();
            case "HELP_CENTER" :
                openMenuItem(option);
                return new HealCenterModalWindow();
            case "WHATS_NEW" :
                openMenuItem(option);
                return new WhatsNewModalWindow();
            case "DARK_THEME" :
                //TODO
                return this;
            default:
                throw new IllegalStateException("Unexpected value: " + option.name());
        }
    }

    @Step("chose logged user menu option")
    public Object loggedUserMenu (MainUserMenu option) {
        switch (option.name()){
            case "PROFILE" :
                openMenuItem(option);
                return new ProfilePage();
            case "PROFILE_SETTINGS" :
                openMenuItem(option);
                return new ProfileSettingsPageFragment();
            case "ACCOUNT_AND_BILLING" :
                openMenuItem(option);
                return new AccountAndBuildingPageFragment();
            case "REFER_A_FRIEND" :
                openMenuItem(option);
                return new ReferAFriendModalWindow();
            case "HELP_CENTER" :
                openMenuItem(option);
                return new HealCenterModalWindow();
            case "WHATS_NEW" :
                openMenuItem(option);
                return new WhatsNewModalWindow();
            case "DARK_THEME" :
                //TODO
                return this;
            case "LANGUAGE" :
                openMenuItem(option);
                return new LanguageDropDown();
            case "SIGN_OUT" :
                openMenuItem(option);
                return new ScreenerPage();
            default:
                throw new IllegalStateException("Unexpected value: " + option.name());
        }
    }

    @Step("get anonymous user menu elements")
    public List<SelenideElement> getAnonymousUserElements() {
        List<SelenideElement> anonymousMenuElements = new ArrayList<>();
        anonymousMenuElements.add(MainUserMenu.SIGNIN.getElement());
        anonymousMenuElements.add(MainUserMenu.HELP_CENTER.getElement());
        anonymousMenuElements.add(MainUserMenu.WHATS_NEW.getElement());
        anonymousMenuElements.add(MainUserMenu.DARK_MODE.getElement());
        return anonymousMenuElements;
    }

    @Step("get logged user menu elements")
    public List<SelenideElement> getLoggedUserElements () {
        List<SelenideElement> loggedMenuelements = new ArrayList<>();
        loggedMenuelements.add(MainUserMenu.PROFILE.getElement());
        loggedMenuelements.add(MainUserMenu.PROFILE_SETTINGS.getElement());
        loggedMenuelements.add(MainUserMenu.ACCOUNT_AND_BILLING.getElement());
        loggedMenuelements.add(MainUserMenu.REFER_A_FRIEND.getElement());
        loggedMenuelements.add(MainUserMenu.HELP_CENTER.getElement());
        loggedMenuelements.add(MainUserMenu.WHATS_NEW.getElement());
        loggedMenuelements.add(MainUserMenu.DARK_MODE.getElement());
        loggedMenuelements.add(MainUserMenu.LANGUAGE.getElement());
        loggedMenuelements.add(MainUserMenu.SIGN_OUT.getElement());
        return loggedMenuelements;
    }

    private void openMenuItem (MainUserMenu option) {
        option.getElement().shouldBe(Condition.clickable);
        option.select();
    }


}
