package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.Base;

public class SearchPage {
	Base b = new Base();

	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "HP LP3065")
	private WebElement validSearchProduct;

	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement noProductMatchField;

	public boolean displaySearchedProduct() {
		return validSearchProduct.isDisplayed();
	}

	public String noMatchMsg() {
		// return noProductMatchField.getText();
		return b.getTextFromElement(noProductMatchField, Base.wait_Time);
	}

	public void user_opens_the_application() {
		Base.setup();
	}

//	public void user_enters_the_valid_product_into_the_search_field(String validProduct ) {
//		driver.findElement(By.cssSelector("input[name='search']")).sendKeys(validProduct);
//	}
//
//	
//	public void user_clicks_on_search_button() {
//	   driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
//	}

//	public void user_should_get_a_valid_product_displayed_in_the_search_results() {
//	    WebElement hpProduct=driver.findElement(By.linkText("HP LP3065"));
//	    Assert.assertTrue(hpProduct.isDisplayed());
//	}

//	public void user_enters_the_invalid_product_into_the_search_field(String invalidProduct) {
//		driver.findElement(By.cssSelector("input[name='search']")).sendKeys(invalidProduct);
//	}

//	public void user_should_get_a_message_about_no_product_match() {
//	   String noMatchMsg=driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText();
//	   Assert.assertEquals("There is no product that matches the search criteria.",noMatchMsg);
//	}

	public void user_enters_nothing_into_into_the_search_field() {
		// kept intentionally blank
	}
}
