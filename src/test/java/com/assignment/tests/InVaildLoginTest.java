package com.assignment.tests;

import com.assignment.pages.HomePage;
import com.assignment.pages.SignInPage;
import com.assignment.utilities.BaseReport;
import com.assignment.utilities.ExcelFile;
import com.assignment.utilities.MyBrowser;
import com.assignment.utilities.StaticProvider;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class InVaildLoginTest extends BaseReport {


    @Test(dataProvider = "LogInSheetInValid", dataProviderClass = StaticProvider.class)
    public void signIn(String TestID,String TestDescription,String Email, String Password,String Expected) throws IOException {

        MyBrowser browser = new MyBrowser("Chrome");
        HomePage homePage = new HomePage(browser);
        homePage.clickSignInButton(browser);
        SignInPage SignInPage = new SignInPage(browser.driver);
        SignInPage.EnterEmailAddress(Email);
        SignInPage.enterPassword(Password);
        SignInPage.clicksSignInButton(browser);
        String ActualMessage= SignInPage.getErrorMessage(browser);

        browser.driver.quit();
        test = extent.createTest(TestID);

        Assert.assertEquals(ActualMessage,Expected);


    }

}

