package com.tradingview.screener.enums;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public enum MainMenuDropdown {

    PRODUCTS("products"),
    COMMUNITY("community"),
    MARKETS("markets"),
    BROKERS("brokers"),
    MODE("more");

    private final String trackId;

    MainMenuDropdown(String trackId) {
        this.trackId = trackId;
    }

    public SelenideElement getElement() {
        return $(byCssSelector(getCssSelector()));
    }

    public String getCssSelector() {
        return String.format("a[data-main-menu-root-track-id='%s']", trackId);
    }

    public String getTrackId() {
        return trackId;
    }

}
