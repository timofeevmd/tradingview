package com.tradingview.screener.modalwinow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class SupportRequestModalWindow {
    private final String title = "div[class*='wizard-header'] h2";
    private final String emptyStateTitle = "p[class*='emptyStateTitle']";

    @Step("get list of elements on the support request modal window")
    public List<SelenideElement> getElements (){
        List<SelenideElement> elements = new ArrayList<>();
        elements.add($(title).shouldBe(Condition.visible));
        elements.add($(emptyStateTitle).shouldBe(Condition.visible));
        return elements;
    }

}
