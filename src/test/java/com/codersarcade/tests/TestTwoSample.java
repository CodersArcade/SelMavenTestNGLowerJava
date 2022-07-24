package com.codersarcade.tests;


import com.coderarcade.pages.HomePage;
import com.codersarcade.base.TestNgTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTwoSample extends TestNgTestBase {

    private HomePage homePage;

    @BeforeMethod
    public void initPageObjects() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void testRegistrationPage() {
        driver.get(baseUrl);
        System.out.println("Header: " + homePage.header.getText());
        Assert.assertTrue("Automation Practice Website".equals(homePage.header.getText()));
        //Enter user details
        homePage.clickSignInButton()
                .signIn("test@gmail.com", "12345")
                .verifyErrorTitleAndMessage("There is 1 error", "Authentication failed.");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
