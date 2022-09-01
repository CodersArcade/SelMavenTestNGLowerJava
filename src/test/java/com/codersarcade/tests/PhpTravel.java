package com.codersarcade.tests;

import com.coderarcade.pages.PhpTravelRegisterPage;
import com.codersarcade.base.TestNgTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhpTravel extends TestNgTestBase {

    private PhpTravelRegisterPage homePage;

    @BeforeMethod
    public void initPageObjects() {
        homePage = PageFactory.initElements(driver, PhpTravelRegisterPage.class);
    }

    @Test
    public void testHomePageHasAHeader() {
        driver.get(baseUrl);
        System.out.println("Header: " + homePage.header.getText());
        Assert.assertEquals(homePage.header.getText(), "Register");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
