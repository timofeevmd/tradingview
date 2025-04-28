package com.tradingview.screener.modalwinow;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class HealCenterModalWindow {

    private final String title = "div[class*='title-container'] h2";
    private final String inputField = "input[id*='input']";
    private final String fasterLinkToCollection = "div[class*='support-app']  div[class*='title']";//"div[class*='support-app'] div[role]";

    @Step("open support request modal window")
    public SupportRequestModalWindow openSupportRequestModalWindow(){
        ElementsCollection elements = $$(fasterLinkToCollection);
        for (SelenideElement element: elements){
            if(element.getText().equals("Support requests")){
                element.click();
            }
        }
        return new SupportRequestModalWindow();
    }
}
