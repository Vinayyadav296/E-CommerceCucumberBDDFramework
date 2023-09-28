package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import helper.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;

public class Register {
   
	HomePage h = new HomePage(Base.driver);
	RegisterPage rp = new RegisterPage(Base.driver);
	AccountSuccessPage ap = new AccountSuccessPage(Base.driver);

	@Given("user navigates to the register account page")
	public void user_navigates_to_the_register_account_page() {
		h.clickOnMyAccount();
		h.selectRegisterOption();
	}

//	public void user_enters_the_details_in_below_fields(io.cucumber.datatable.DataTable dataTable)

	@When("user enters the details in below fields")
	public void user_enters_the_details_in_below_fields(DataTable dataTableText) {
		Map<String, String> dataMap = dataTableText.asMap(String.class, String.class);

		rp.enterFirstName(dataMap.get("firstName"));
		rp.enterLastName(dataMap.get("lastName"));
		rp.enterEmailField(dataMap.get("email"));
		rp.enterTelephone(dataMap.get("telephone"));
		rp.enterPassword(dataMap.get("password"));
		rp.enterConfirmPassword(dataMap.get("password"));
	}

	@When("user clicks on privacy policy")
	public void user_clicks_on_privacy_policy() {
		rp.selectPrivacyPolicy();
	}

	@Then("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		rp.clickContinueBtn();
	}

	@Then("user account should created successfully")
	public void user_account_should_created_successfully() {
		String confirmationText = ap.accountCreatedConfirmation();
		Assert.assertEquals("Your Account Has Been Created!", confirmationText);
	}

	@When("user select yes for news letter")
	public void user_select_yes_for_news_letter() {
		rp.clickYesForNewsLetter();
	}

	@Then("user should get a warning message about duplicate email")
	public void user_should_get_a_warning_message_about_duplicate_email() {
		Assert.assertTrue(rp.duplicateEmailWarning().contains("Warning: E-Mail Address is already registered!"));
	}

//	@When("user enters the details in below fields")
//	public void user_enters_the_details_in_below_fields() {
//	   
//	}

	@When("user does not filled any details into the fields")
	public void user_does_not_filled_any_details_into_the_fields() {
		rp.user_does_not_filled_any_details_into_the_fields();
	}

	@Then("user should get a warning message for filling every mandatory fields")
	public void user_should_get_a_warning_message_for_filling_every_mandatory_fields() {
		
		Assert.assertTrue (rp.duplicateEmailWarning().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertTrue(rp.getFirstNameWarning().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(rp.getlastNameWarning().contains("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(rp.getEmailWarning().contains("E-Mail Address does not appear to be valid"));
		Assert.assertTrue(rp.getTelephoneWarning().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(rp.getPasswordWarning().contains("Password must be between 4 and 20 characters!"));

		
		
	}

}
