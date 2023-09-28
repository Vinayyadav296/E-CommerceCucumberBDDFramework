package stepDefinitions;

import org.junit.Assert;

import helper.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class Login  {
	
	LoginPage lp=new LoginPage(Base.driver);
	HomePage hp=new HomePage(Base.driver);
	
	@Given("User navigate to the login page")
	public void user_navigate_to_the_login_page()  {
//		lp.clickOnMyAccount();
//		lp.selectLoginOption();
		hp.clickOnMyAccount();
		hp.selectLoginOption();
	}
	
	@When("user enter the valid email address {string} into email field")
	public void user_enter_the_valid_email_address_into_email_field(String emailText) {
		lp.enterEmail(emailText);
	}
	
	@When("user enter the valid password {string} into the password field")
	public void user_enter_the_valid_password_into_the_password_field(String passwordText) {
           lp.enterPassword(passwordText);
	}	
    
	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		lp.clickOnLoginButton();
	}
	
	@Then("user should be able to login successfully")
	public void user_should_be_able_to_login_successfully() {
     Assert.assertTrue(lp.verifyAccountPage());
	}
	
	@When("user enter the invalid email address {string} into email field")
	public void user_enter_the_invalid_email_address_into_email_field(String invalidEmailText) {
       lp.enterEmail(invalidEmailText);
	}
    
	@When("user enter the invalid password {string} into the password field")
	public void user_enter_the_invalid_password_into_the_password_field(String invalidPasswordText) {
		lp.enterPassword(invalidPasswordText);
	}
	
	@Then("user should get proper warning message of invalid credentials")
	public void user_should_get_proper_warning_message_of_invalid_credentials() {
	  Assert.assertTrue(lp.getWarningMsg().contains("Warning: No match for E-Mail Address and/or Password."));	
	}
	
	@When("user does not provide any email address in the email field")
	public void user_does_not_provide_any_email_address_in_the_email_field() {
       lp.enterEmail("");
	}
	
	@When("user does not provide any password in the password field")
	public void user_does_not_provide_any_password_in_the_password_field() {
		lp.enterPassword("");
	}
	
   	
	

//	@Given("User navigate to the login page")
//	public void user_navigate_to_the_login_page()  {
//		lp.user_navigate_to_the_login_page();
//	}
//
//	@When("user enter the valid email address {string} into email field")
//	public void user_enter_the_valid_email_address_into_email_field(String emailText) {
//		lp.user_enter_the_valid_email_address_into_email_field(emailText);
//	}
//
//	@When("user enter the valid password {string} into the password field")
//	public void user_enter_the_valid_password_into_the_password_field(String passwordText) {
//           lp.user_enter_the_valid_password_into_the_password_field(passwordText);
//	}
//
//	@When("user clicks on the login button")
//	public void user_clicks_on_the_login_button() {
//		lp.user_clicks_on_the_login_button();
//	}
//
//	@Then("user should be able to login successfully")
//	public void user_should_be_able_to_login_successfully() {
//     lp.user_should_be_able_to_login_successfully();
//	}
//
//	@When("user enter the invalid email address {string} into email field")
//	public void user_enter_the_invalid_email_address_into_email_field(String invalidEmailText) {
//       lp.user_enter_the_invalid_email_address_into_email_field(invalidEmailText);
//	}
//
//	@When("user enter the invalid password {string} into the password field")
//	public void user_enter_the_invalid_password_into_the_password_field(String invalidPasswordText) {
//		lp.user_enter_the_invalid_password_into_the_password_field(invalidPasswordText);
//	}
//
//	@Then("user should get proper warning message of invalid credentials")
//	public void user_should_get_proper_warning_message_of_invalid_credentials() {
//	  lp.user_should_get_proper_warning_message_of_invalid_credentials();	
//	}
//
//	@Then("user should get the warning message of the invalid password")
//	public void user_should_get_the_warning_message_of_the_invalid_password() {
//       lp.user_should_get_the_warning_message_of_the_invalid_password();
//	}
//
//	@Then("user should get the warning message of the invalid email")
//	public void user_should_get_the_warning_message_of_the_invalid_email() {
//     lp.user_should_get_the_warning_message_of_the_invalid_email();
//	}
//
////	@Given("user navigate to the login page")
////	public void user_navigate_to_the_login_page() {
////	    
////	}
//
//	@When("user does not provide any email address in the email field")
//	public void user_does_not_provide_any_email_address_in_the_email_field() {
//       lp.user_does_not_provide_any_email_address_in_the_email_field();
//	}
//
//	@When("user does not provide any password in the password field")
//	public void user_does_not_provide_any_password_in_the_password_field() {
//		lp.user_does_not_provide_any_password_in_the_password_field();
//	}
//
////	@When("user click on the login button")
////	public void user_click_on_the_login_button() {
////	   lp.user_clicks_on_the_login_button();
////	}
//
//	@Then("user should get the warning message of enter email and password")
//	public void user_should_get_the_warning_message_of_enter_email_and_password() {
//	   lp.user_should_get_the_warning_message_of_enter_email_and_password();
//	}

}
