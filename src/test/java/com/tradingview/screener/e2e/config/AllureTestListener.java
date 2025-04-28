package com.tradingview.screener.e2e.config;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.codeborne.selenide.Selenide.screenshot;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;

public class AllureTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(">>> ТЕСТ УПАЛ. Драйвер жив? " + hasWebDriverStarted());
        screenshot("failure");
        attachScreenshot();
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    private byte[] attachScreenshot() {
        try {
            WebDriver driver = WebDriverRunner.getWebDriver();
            if (driver != null && driver instanceof TakesScreenshot) {
                byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                System.out.println(">>> Скриншот успешно снят, размер: " + bytes.length + " байт");
                return bytes;
            } else {
                System.out.println(">>> Не получилось сделать скриншот: драйвер = null или не умеет TakesScreenshot");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }


    /*@Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] saveScreenshotOnFailure() {
        File screenshot = Screenshots.getLastScreenshot();
        if (screenshot != null && screenshot.exists()) {
            try {
                return Files.readAllBytes(screenshot.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new byte[0];
    }*/
}
