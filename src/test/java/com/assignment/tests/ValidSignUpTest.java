package com.assignment.tests;

import com.assignment.pages.CreateAccountIntPage;
import com.assignment.pages.CreateAccountPage;
import com.assignment.pages.HomePage;
import com.assignment.utilities.BaseReport;
import com.assignment.utilities.ExcelFile;
import com.assignment.utilities.MyBrowser;
import com.assignment.utilities.StaticProvider;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class ValidSignUpTest extends BaseReport {



	@Test(dataProvider = "SignUpSheetValid", dataProviderClass = StaticProvider.class)
	public void signUpRegister(String TestID,String TestDescription,String FirstName,
			String LastName, String Email, String Password,String Address, String City,
							   String State, String ZipCode, String Country,
							   String MobilePhone,String AliasEmail,String ExpectedMessage) throws IOException {

		MyBrowser browser = new MyBrowser("Chrome");

		HomePage homePage = new HomePage(browser);
		homePage.clickSignInButton(browser);
		CreateAccountIntPage enterEmailPage = new CreateAccountIntPage(browser.driver);
		enterEmailPage.EnterEmailAddress(Email);
		enterEmailPage.clickCreateAccountButton(browser);
		CreateAccountPage createAccount = new CreateAccountPage(browser.driver);
		createAccount.enterFirstName(FirstName);
		createAccount.enterLastName(LastName);
		createAccount.enterPassword(Password);
		createAccount.enterAddress(Address);
		createAccount.enterCity(City);
		createAccount.selectState(State);
		createAccount.enterZipCode(ZipCode);
		createAccount.enterMobileNum(MobilePhone);
		createAccount.enterAliasEmailAddress(AliasEmail);
		createAccount.clickRegisterButton(browser);
		String ActualMessage=createAccount.getMessage(browser);

		browser.driver.quit();
		test = extent.createTest(TestID);

		Assert.assertEquals(ActualMessage,ExpectedMessage);



	}






}
