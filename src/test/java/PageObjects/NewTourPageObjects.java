package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTourPageObjects {
	
	public NewTourPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@name = 'userName']")
	public WebElement usrname;
	
	@FindBy(xpath = "//*[@name = 'password']")
	public WebElement password;
	
	@FindBy(xpath = "//*[@name = 'login']")
	public WebElement Login;
	
	@FindBy(xpath = "//*[contains(text(), 'REGISTER')]")
	public WebElement lnkRegistration;
	
	@FindBy(xpath = "//*[@name = 'firstName']")
	public WebElement edtFirstName;
	
	@FindBy(xpath = "//*[@name = 'lastName']")
	public WebElement edtLastname;
	
	@FindBy(xpath = "//*[@name = 'phone']")
	public WebElement edtphone;
	
	@FindBy(id = "userName")
	public WebElement edtEmail;
	
	@FindBy(xpath = "//*[@name = 'address1']")
	public WebElement edtAddress1;
	
	@FindBy(xpath = "//*[@name = 'city']")
	public WebElement edtCity;
	
	@FindBy(xpath = "//*[@name = 'state']")
	public WebElement edtState;
	
	@FindBy(xpath = "//*[@name = 'postalCode']")
	public WebElement edtPostalCode;
	
	@FindBy(xpath = "//*[@name = 'country']")
	public WebElement selectCountry;
	
	@FindBy(id = "email")
	public WebElement edtUserName;
	
	@FindBy(xpath = "//*[@name = 'confirmPassword']")
	public WebElement edtConfirmPassword;
	
	@FindBy(xpath = "//*[@name = 'register']")
	public WebElement btnRegister;
	
	@FindBy(xpath = "//*[contains(text(), 'sign-in')]")
	public WebElement lnkSignIn;
	
	@FindBy(xpath = "//*[@name = 'passCount']")
	public WebElement selPassCount;
	
	@FindBy(xpath = "//*[@name = 'fromMonth']")
	public WebElement selfromMonth;
	
	@FindBy(xpath = "//*[@name = 'fromDay']")
	public WebElement selfromDay;
	
	@FindBy(xpath = "//*[@name = 'fromPort']")
	public WebElement selfromPort;
	
	@FindBy(xpath = "//*[@name = 'toPort']")
	public WebElement seltoPort;
	
	@FindBy(xpath = "//*[@name = 'toMonth']")
	public WebElement seltoMonth;
	
	@FindBy(xpath = "//*[@name = 'toDay']")
	public WebElement seltoDay;
	
	@FindBy(xpath = "//*[@name = 'servClass']")
	public List<WebElement> rdoservClass;
	
	@FindBy(xpath = "//*[@name = 'airline']")
	public WebElement selairline;
	
	@FindBy(xpath = "//*[@name = 'findFlights']")
	public WebElement btnfindFlights;
	
	@FindBy(xpath = "//*[@name = 'tripType']")
	public List<WebElement> rdotripType;
}
