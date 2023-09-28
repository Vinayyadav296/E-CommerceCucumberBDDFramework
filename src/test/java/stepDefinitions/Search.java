package stepDefinitions;

import org.junit.Assert;

import helper.Base;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchPage;

public class Search {
     SearchPage sp=new SearchPage(Base.driver);
     HomePage hp=new HomePage(Base.driver);
     
	@Given("user opens the application")
	public void user_opens_the_application() {
	    sp.user_opens_the_application();
	}
	
	@When("user enters the valid product {string} into the search field")
	public void user_enters_the_valid_product_into_the_search_field(String validProductText ) {
		hp.enterProductInSearchField(validProductText);
	}
    
	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
	   hp.clickSearchButton();
	}
	
	@Then("user should get a valid product displayed in the search results")
	public void user_should_get_a_valid_product_displayed_in_the_search_results() {
	    Assert.assertTrue(sp.displaySearchedProduct());
	}	

	@When("user enters the invalid product {string} into the search field")
	public void user_enters_the_invalid_product_into_the_search_field(String invalidProductText) {
	    hp.enterProductInSearchField(invalidProductText);
	}
	
//	@When("user enters the valid product {string} into the search field")
//	public void user_enters_the_valid_product_into_the_search_field(String validProductText ) {
//		sp.user_enters_the_valid_product_into_the_search_field(validProductText);
//	}

//	@When("user clicks on search button")
//	public void user_clicks_on_search_button() {
//	   sp.user_clicks_on_search_button();
//	}

//	@Then("user should get a valid product displayed in the search results")
//	public void user_should_get_a_valid_product_displayed_in_the_search_results() {
//	    sp.user_should_get_a_valid_product_displayed_in_the_search_results();;
//	}
	
//	@When("user enters the invalid product {string} into the search field")
//	public void user_enters_the_invalid_product_into_the_search_field(String invalidProductText) {
//	    sp.user_enters_the_invalid_product_into_the_search_field(invalidProductText);
//	}


	@Then("user should get a message about no product match")
	public void user_should_get_a_message_about_no_product_match() {
		Assert.assertEquals("There is no product that matches the search criteria.",sp.noMatchMsg());
	}

	@When("user enters nothing into into the search field")
	public void user_enters_nothing_into_into_the_search_field() {
	    sp.user_enters_nothing_into_into_the_search_field();
	}



}
