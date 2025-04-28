package com.tradingview.screener.modalwinow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.tradingview.screener.pages.ScreenerPage;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SignInModalWindow {
    private final String modalWindow = "div[data-qa-id='ui-lib-PopupDialog']";
    private final String closeBtn = "div[class*='button'] button";
    private final String googleSignInBtn = "div[class*='googleButton']";
    private final String facebookSignInBtn = "button[id='facebook']";
    private final String twitterSignInBtn = "button[id='twitter']";
    private final String yahooSignInBtn = "button[id='yahoo']";
    private final String appleIdSignInBtn = "button=[id='apple-id']";
    private final String linkedinSignInBtn = "button=[id='linkedin-oauth2']";
    private final String emailSignInBtn = "button[name='Email']";
    private final String signinBtn = "button[class*='submitButton']";
    private final String signUpBtn = "div[class*='footer'] a";
    private final String emailInputField = "input[data-qa-id='ui-lib-Input-input']";
    private final List<String> credentials = List.of("418localhost@gmail.com", "Nb213659G_16");

    @Step("click email Sign In button")
    public SignInModalWindow emailSignIn(){
        SelenideElement emailBtn = $(emailSignInBtn).shouldBe(Condition.clickable);
        emailBtn.click();
        return this;
    }

    @Step("set Username/Password")
    public SignInModalWindow setUserPassword(){
        ElementsCollection loginPassword = $$(emailInputField);
        IntStream.range(0, credentials.size())
                        .forEach(i ->
                                loginPassword.get(i)
                                        .sendKeys(credentials.get(i)
                                        )

        );
        return this;
    }

    @Step("click sign in button")
    public ScreenerPage signIn(){
        SelenideElement signInBtn = $(signinBtn).shouldBe(Condition.visible);
        signInBtn.click();
        return new ScreenerPage();
    }

}
