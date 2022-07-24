package com.codersarcade.tests;


import com.coderarcade.pages.HomePage;
import com.codersarcade.base.TestNgTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleJUnitTest extends TestNgTestBase {

    private HomePage homePage;

    @BeforeMethod
    public void initPageObjects() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void testHomePageHasAHeader() {
        driver.get(baseUrl);
        System.out.println("Header: " + homePage.header.getText());
        Assert.assertTrue("Automation Practice Website".equals(homePage.header.getText()));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
