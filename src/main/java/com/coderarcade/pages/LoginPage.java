package com.coderarcade.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;

    @FindBy(id = "email")
    public WebElement usernameElem;

    @FindBy(id = "passwd")
    private WebElement passwordElem;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButtonElem;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]/p")
    private WebElement errorTitleElem;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]/ol/li")
    private WebElement errorMessageElem;

    public LoginPage signIn(String username, String password) {
        usernameElem.sendKeys(username);
        passwordElem.sendKeys(password);
        signInButtonElem.click();
        return this;
    }

    public void verifyErrorTitleAndMessage(String errorTitle, String errorMessage) {
        Assert.assertEquals(errorTitle, errorTitleElem.getText());
        Assert.assertEquals(errorMessage, errorMessageElem.getText());
        System.out.println("Error details verified correctly");
    }

}
