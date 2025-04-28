package com.tradingview.screener.enums.dropdown;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public enum MainUserMenu {

    SIGNIN ("signIn"),
    PROFILE ("profile"),
    PROFILE_SETTINGS ("profileSettings"),
    ACCOUNT_AND_BILLING ("accountAndBilling"),
    REFER_A_FRIEND ("refererAFriend"),
    HELP_CENTER ("helpCenter"),
    WHATS_NEW ("whatsNew"),
    DARK_MODE ("darkMode"),
    LANGUAGE ("language"),
    SIGN_OUT ("signOut");

    private final String trackId;
    private final String signIn = "button[data-name='header-user-menu-sign-in']";
    private final String profile = "a[data-name='header-user-menu-profile']";
    private final String profileSettings = "a[data-name='header-user-menu-profile-settings']";
    private final String refererAFriend = "button[data-name='header-user-menu-referred-friends']";
    private final String accountAndBilling = "button[data-name='header-user-menu-referred-friends']";
    private final String helpCenter = "button[data-name='header-user-menu-help-center']";
    private final String whatsNew = "button[role='menuitem']:nth-of-type(3)";
    private final String darkMode = "input[data-name='header-user-menu-switch-theme']";
    private final String language = "button[role='menuitem'] svg";
    private final String signOut = "button[data-name='header-user-menu-sign-out']";

    MainUserMenu(String trackId) {
        this.trackId = trackId;
    }

    public SelenideElement getElement() {
        switch (trackId) {
            case "signIn" :
                return findElement(signIn);
            case "profile" :
                return findElement(profile);
            case "profileSettings" :
                return findElement(profileSettings);
            case "accountAndBilling" :
                return findElement(accountAndBilling);
            case "refererAFriend" :
                return findElement(refererAFriend);
            case "helpCenter" :
                return findElement(helpCenter);
            case "whatsNew" :
                return findElement(whatsNew);
            case "darkMode" :
                return findElement(darkMode);
            case "language" :
                return findElement(language);
            case "signOut" :
                return findElement(signOut);
            default:
                throw new IllegalStateException("Unexpected value: " + trackId);
        }
    }

    public void select() {
        getElement().click();
    }

    private SelenideElement findElement (String cssSelector) {
        return $(cssSelector).shouldBe(Condition.clickable);
    }
}
