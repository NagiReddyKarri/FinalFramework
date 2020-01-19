package StepDefinition;

import HelperClassesMethods.NewTourHomeScreenmethods;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NewtoursStepDefination {
	
	NewTourHomeScreenmethods newTourHomeScreen = new NewTourHomeScreenmethods();
	
	@When("^Launch the application$")
	public void launch_the_application() {
		newTourHomeScreen.launchApplication();
	}

	@Then("^Login to application with valid credentails$")
	public void enter_the_credentails(){
		newTourHomeScreen.loginwithcredentials();
	}
	
	@Then("^Verify login page displayed$")
	public void Verify_login_page_displayed(){
		newTourHomeScreen.verifyHomeScreen();
	}

	@When("^Click on Registration link$")
	public void click_on_Registration_link() {
		newTourHomeScreen.clickRegistrationLink();
	}
 
	@Then("^Enter the customer details$")
	public void Enter_the_customer_details(){
		newTourHomeScreen.registrationFormFill();
	}
	
	@Then("^Verify the Success message after registration$")
	public void verify_the_Success_message_after_registration(){
		newTourHomeScreen.successMessageVerification();
	}
	
	@Then("^CLick on sign-in hyperlink and verify login page displayed$")
	public void CLick_on_sign_in_hyperlink_and_verify_login_page_displayed(){
		newTourHomeScreen.clickSignin();
	}
	
	@Then("^Choose the round trip details$")
	public void Choose_the_round_trip_details(){
		newTourHomeScreen.roundTripDetails();
	}
	
	@Then("^Choose the OneWay trip details$")
	public void Choose_the_OneWay_trip_details(){
		newTourHomeScreen.oneWayTripDetails();
	}
	
	
	@Then("^Verify the Search result display for round trip$")
	public void Verify_the_Search_result_display(){
		newTourHomeScreen.verifyRoundtripResult();
	}
	
	@Then("^Verify the Search result display for OneWay trip$")
	public void Verify_the_Search_result_display_for_OneWay_trip(){
		newTourHomeScreen.verifyOneWaytripResult();
	}
	
	@Then("^Login to application with (.*),(.*) credentails$")
	public void Login_to_application_with_Different_credentails(String Username, String Password){
		newTourHomeScreen.Genericloginwithcredentials( Username,  Password);
	}
	
	
}
