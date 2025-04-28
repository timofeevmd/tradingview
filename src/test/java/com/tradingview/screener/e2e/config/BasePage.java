package com.tradingview.screener.e2e.config;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class BasePage extends BaseTest{

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(){
        driver = getDriver();
        open("https://www.tradingview.com/screener/");

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
        );
    }
}
