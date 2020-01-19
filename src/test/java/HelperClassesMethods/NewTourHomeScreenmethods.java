package HelperClassesMethods;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.cucumber.listener.Reporter;

import PageObjects.NewTourPageObjects;
import Utilities.BaseClass;
import Utilities.CommonLibraries;
import Utilities.ExcelConfig;

public class NewTourHomeScreenmethods {
	BaseClass baseClass = new BaseClass();
	public WebDriver driver = baseClass.setDriver();
	CommonLibraries commonLibraries = new CommonLibraries();
	NewTourPageObjects newTourPageObjects = new NewTourPageObjects(driver);
	ExcelConfig excelConfig = new ExcelConfig();
	String username = excelConfig.readTestData("Data", "User Name");
	String password = excelConfig.readTestData("Data", "Password");
	String firstname = excelConfig.readTestData("Data", "FirstName");
	String lastname = excelConfig.readTestData("Data", "LastName");
	String phoneNumber = excelConfig.readTestData("Data", "PhoneNumber");
	String email = excelConfig.readTestData("Data", "Email");
	String addressLine1 = excelConfig.readTestData("Data", "AddressLine1");
	String city = excelConfig.readTestData("Data", "City");
	String state = excelConfig.readTestData("Data", "State");
	String postalCode = excelConfig.readTestData("Data", "PostalCode");
	String country = excelConfig.readTestData("Data", "Country");
	String confirmPassword = excelConfig.readTestData("Data", "ConfirmPassword");
	String fromStation = excelConfig.readTestData("Data", "fromStation");
	String toStation = excelConfig.readTestData("Data", "toStation");
	String airline = excelConfig.readTestData("Data", "Airline");
	Date date = new Date();
	String currentdate = CommonLibraries.dateAdd("M/d/yyyy",date, 0);
	String futureDate = CommonLibraries.dateAdd("M/d/yyyy",date, 25);
	

	/**
	 **********************************************************************
	 * @MethodName : launchApplication()
	 * @Description : This function is used to launch Application
	 * @Author : Nagi
	 ***********************************************************************
	 */
	public void launchApplication() {
		try {
			BaseClass.launchURL();
			commonLibraries.waitForBrowserLoads();

		} catch (Exception e) {
			commonLibraries.takeScreenShot();
			Assert.fail("Failed in LaunchApplication method " + e.getMessage());
		}
	}

	/**
	 **********************************************************************
	 * @MethodName : loginwithcredentials()
	 * @Description : This function is used to enter the credentials and click on Sign in
	 * @Author : Nagi
	 ***********************************************************************
	 */
	public void loginwithcredentials() {
		try {

			commonLibraries.sendText(newTourPageObjects.usrname, username, "UserName");
			// commonLibraries.takeScreenShot();
			commonLibraries.sendText(newTourPageObjects.password, password, "Password");
			// commonLibraries.takeScreenShot();
			commonLibraries.clickElement(newTourPageObjects.Login, "Login button");
			// commonLibraries.takeScreenShot();
			commonLibraries.waitForBrowserLoads();
		} catch (Exception e) {
			commonLibraries.takeScreenShot();
			Assert.fail("Failed in loginwithcredentails method " + e.getMessage());
		}
	}

	/**
	 **********************************************************************
	 * @MethodName : verifyHomeScreen()
	 * @Description : This function is used to verify Home Screen after successful login
	 * @Author : Nagi
	 ***********************************************************************
	 */
	public void verifyHomeScreen() {
		try {
			String title = driver.getTitle();
			if (title.trim().equalsIgnoreCase("Find a Flight: Mercury Tours:")) {
				Reporter.addStepLog("Home page was displayed successfully");
			} else {
				Assert.fail("Home page was not displayed");
			}
		} catch (Exception e) {
			commonLibraries.takeScreenShot();
			Assert.fail("Failed in verifyHomeScreen method " + e.getMessage());
		}
	}

	/**
	 **********************************************************************
	 * @MethodName : clickRegistrationLink()
	 * @Description : This function is used to click Registration Link
	 * @Author : Nagi
	 ***********************************************************************
	 */
	public void clickRegistrationLink() {
		try {
			commonLibraries.waitForBrowserLoads();
			commonLibraries.executorClick(newTourPageObjects.lnkRegistration, "Registration Link");
			commonLibraries.waitForBrowserLoads();
		} catch (Exception e) {
			commonLibraries.takeScreenShot();
			Assert.fail("Failed in clickRegistrationLink method " + e.getMessage());
		}
	}

	/**
	 **********************************************************************
	 * @MethodName : registrationFormFill()
	 * @Description : This function is used to fill registration form
	 * @Author : Nagi
	 ***********************************************************************
	 */
	public void registrationFormFill() {
		try {
			commonLibraries.waitForBrowserLoads();
			commonLibraries.sendText(newTourPageObjects.edtFirstName, firstname, "First Name");
			commonLibraries.sendText(newTourPageObjects.edtLastname, lastname, "Last Name");
			commonLibraries.sendText(newTourPageObjects.edtphone, phoneNumber, "Phone Number");
			commonLibraries.sendText(newTourPageObjects.edtEmail, email, "Email");
			commonLibraries.sendText(newTourPageObjects.edtAddress1, addressLine1, "Address Line1");
			commonLibraries.sendText(newTourPageObjects.edtCity, city, "City");
			commonLibraries.sendText(newTourPageObjects.edtState, state, "State");
			commonLibraries.sendText(newTourPageObjects.edtPostalCode, postalCode, "Postal Code");
			commonLibraries.scrollInToView(newTourPageObjects.btnRegister);
			commonLibraries.selectByVisibleText(newTourPageObjects.selectCountry, country);
			commonLibraries.sendText(newTourPageObjects.edtUserName, username, "User name");
			commonLibraries.sendText(newTourPageObjects.password, password, "Password");
			commonLibraries.sendText(newTourPageObjects.edtConfirmPassword, confirmPassword, "Confirm Password");
			commonLibraries.clickElement(newTourPageObjects.btnRegister, "Submit button");
			commonLibraries.waitForBrowserLoads();
		} catch (Exception e) {
			commonLibraries.takeScreenShot();
			Assert.fail("Failed in registrationFormFill method " + e.getMessage());
		}
	}

	/**
	 **********************************************************************
	 * @MethodName : successMessageVerification()
	 * @Description : This function is used to verification success Message after registration
	 * @Author : Nagi
	 ***********************************************************************
	 */
	public void successMessageVerification() {
		try {
			commonLibraries.waitForBrowserLoads();
			String nameMessage = "Dear "+ firstname + " " + lastname;
			WebElement message = driver.findElement(By.xpath("//*[contains(text(), '" + nameMessage + "')]"));
			if (message.isDisplayed()) {
				Reporter.addStepLog("User was successfully registered");
			} else {
				commonLibraries.takeScreenShot();
				Assert.fail("User Failed to register");
			}
		} catch (Exception e) {
			commonLibraries.takeScreenShot();
			Assert.fail("Failed in successMessageVerification method " + e.getMessage());
		}
	}
	
	/**
	 **********************************************************************
	 * @MethodName : clickSignin()
	 * @Description : This function is used to click Sign in hyper link after registration
	 * @Author : Nagi
	 ***********************************************************************
	 */
	public void clickSignin()
	{
		try {
			commonLibraries.clickElement(newTourPageObjects.lnkSignIn, "Sign In");
			commonLibraries.waitForBrowserLoads();
			if(newTourPageObjects.usrname.isDisplayed())
			{
				Reporter.addStepLog("Successfully landed on Sign on page");
			}else
			{
				Assert.fail("Failed to click on Sign In hyperlink");
			}
		}  catch (Exception e) {
			commonLibraries.takeScreenShot();
			Assert.fail("Failed in clickSignin method " + e.getMessage());
		}
	}
	
	/**
	 **********************************************************************
	 * @MethodName : roundTripDetails()
	 * @Description : This function is used to enter round trip details
	 * @Author : Nagi
	 ***********************************************************************
	 */
	public void roundTripDetails()
	{
		try {
			commonLibraries.waitForBrowserLoads();
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(newTourPageObjects.selPassCount));
			genericRadioSelect("roundtrip", newTourPageObjects.rdotripType);
			String [] A1 = currentdate.split("/");
			String currentmonth = A1[0];
			String currentDay = A1[1];
			String [] B1 = futureDate.split("/");
			String futuremonth = B1[0];
			String futureDay = B1[1];
			commonLibraries.selectByValue(newTourPageObjects.selPassCount, "2");
			commonLibraries.selectByValue(newTourPageObjects.selfromPort, fromStation);
			commonLibraries.selectByValue(newTourPageObjects.selfromMonth, currentmonth);
			commonLibraries.selectByValue(newTourPageObjects.selfromDay, currentDay);
			commonLibraries.selectByValue(newTourPageObjects.seltoPort, toStation);
			commonLibraries.selectByValue(newTourPageObjects.seltoMonth, futuremonth);
			commonLibraries.selectByValue(newTourPageObjects.seltoDay, futureDay);
			genericRadioSelect("Business", newTourPageObjects.rdoservClass);
			commonLibraries.selectByVisibleText(newTourPageObjects.selairline, airline);
			commonLibraries.clickElement(newTourPageObjects.btnfindFlights, "Continue button");
			commonLibraries.waitForBrowserLoads();
		} catch (Exception e) {
			commonLibraries.takeScreenShot();
			Assert.fail("Failed in roundTripDetails method " + e.getMessage());
		}
	}

	/**
	 **********************************************************************
	 * @MethodName : oneWayTripDetails()
	 * @Description : This function is used to enter one way trip details
	 * @Author : Nagi
	 ***********************************************************************
	 */
	public void oneWayTripDetails()
	{
		try {
			commonLibraries.waitForBrowserLoads();
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(newTourPageObjects.selPassCount));
			genericRadioSelect("oneway", newTourPageObjects.rdotripType);
			String [] A1 = currentdate.split("/");
			String currentmonth = A1[0];
			String currentDay = A1[1];
			commonLibraries.selectByValue(newTourPageObjects.selPassCount, "2");
			commonLibraries.selectByValue(newTourPageObjects.selfromPort, fromStation);
			commonLibraries.selectByValue(newTourPageObjects.selfromMonth, currentmonth);
			commonLibraries.selectByValue(newTourPageObjects.selfromDay, currentDay);
			commonLibraries.selectByValue(newTourPageObjects.seltoPort, toStation);
			commonLibraries.selectByValue(newTourPageObjects.seltoMonth, currentmonth);
			commonLibraries.selectByValue(newTourPageObjects.seltoDay, currentDay);
			genericRadioSelect("Business", newTourPageObjects.rdoservClass);
			commonLibraries.selectByVisibleText(newTourPageObjects.selairline, airline);
			commonLibraries.clickElement(newTourPageObjects.btnfindFlights, "Continue button");
			commonLibraries.waitForBrowserLoads();
		} catch (Exception e) {
			commonLibraries.takeScreenShot();
			Assert.fail("Failed in roundTripDetails method " + e.getMessage());
		}
	}
	
	/**
	 **********************************************************************
	 * @MethodName : verifyRoundtripResult()
	 * @Description : This function is used to verify round trip result
	 * @Author : Nagi
	 ***********************************************************************
	 */
	public void verifyRoundtripResult()
	{
		try {
			genericVerification("from date", currentdate);
			String fromtoTrip = fromStation+" to "+toStation;
			String tofromtrip = toStation+" to "+fromStation;
			genericVerification("from to Trip details", fromtoTrip);
			genericVerification("To date", futureDate);
			genericVerification("to from trip details", tofromtrip);
		}catch (Exception e) {
			commonLibraries.takeScreenShot();
			Assert.fail("Failed in verifyResult method " + e.getMessage());
		}
	}
	
	/**
	 **********************************************************************
	 * @MethodName : verifyOneWaytripResult()
	 * @Description : This function is used to verify OneWay trip result
	 * @Author : Nagi
	 ***********************************************************************
	 */
	public void verifyOneWaytripResult()
	{
		try {
			genericVerification("from date", currentdate);
			String fromtoTrip = fromStation+" to "+toStation;
			genericVerification("from to Trip details", fromtoTrip);
		}catch (Exception e) {
			commonLibraries.takeScreenShot();
			Assert.fail("Failed in verifyResult method " + e.getMessage());
		}
	}
	
	/**
	 **********************************************************************
	 * @MethodName : genericVerification()
	 * @Description : This function is used to Verify elements are displayed
	 * @Author : Nagi
	 ***********************************************************************
	 */	
	public void genericVerification(String parameter, String verifyvalue)
	{
		try {
			if(driver.findElement(By.xpath("//*[contains(text(),'"+verifyvalue+"')]")).isDisplayed())
			{
				Reporter.addStepLog("Selected "+parameter+" result was displayed");
			}else
			{
				commonLibraries.takeScreenShot();
				Assert.fail("Selected "+parameter+" result was not displayed");
			}
		} catch (Exception e) {
			commonLibraries.takeScreenShot();
			Assert.fail("Failed in genericVerification method " + e.getMessage());
		}
	}
	
	/**
	 **********************************************************************
	 * @MethodName : genericRadioSelect()
	 * @Description : This function is used to select the radio button
	 * @Author : Nagi
	 ***********************************************************************
	 */
	public void genericRadioSelect(String selValue, List<WebElement> Weblist)
	{
		try {
			List<WebElement> list = Weblist;
			for(WebElement lst: list)
			{
				String radioVal = lst.getAttribute("value");
				if(radioVal.equalsIgnoreCase(selValue))
				{
					lst.click();
					break;
				}
			}
		} catch (Exception e) {
			commonLibraries.takeScreenShot();
			Assert.fail("Failed in radioSelect method " + e.getMessage());
		}
	}
	
	/**
	 **********************************************************************
	 * @MethodName : loginwithcredentials()
	 * @Description : This function is used to enter the credentials and click on Sign in
	 * @Author : Nagi
	 ***********************************************************************
	 */
	public void Genericloginwithcredentials(String Username, String Password) {
		try {

			commonLibraries.sendText(newTourPageObjects.usrname, Username, "UserName");
			// commonLibraries.takeScreenShot();
			commonLibraries.sendText(newTourPageObjects.password, Password, "Password");
			// commonLibraries.takeScreenShot();
			commonLibraries.clickElement(newTourPageObjects.Login, "Login button");
			// commonLibraries.takeScreenShot();
			commonLibraries.waitForBrowserLoads();
		} catch (Exception e) {
			commonLibraries.takeScreenShot();
			Assert.fail("Failed in Genericloginwithcredentials method " + e.getMessage());
		}
	}
}
