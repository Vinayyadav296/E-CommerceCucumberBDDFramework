package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.Base;

public class HomePage {

	Base b = new Base();

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[.='My Account']")
	private WebElement myAccountDropDownMenu;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(css = "input[name='search']")
	private WebElement searchField;

	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchBtn;

	public void clickOnMyAccount() {
		// myAccountDropDownMenu.click();
		b.clickOnElement(myAccountDropDownMenu, 15);
	}

	public void selectRegisterOption() {
		// registerOption.click();
		b.clickOnElement(registerOption, 15);
	}

	public void selectLoginOption() {
		// loginOption.click();
		b.clickOnElement(loginOption, 15);
	}

	public void enterProductInSearchField(String validProduct) {
		// searchField.sendKeys(validProduct);
		b.typeTextIntoElement(searchField, validProduct, 15);
	}

	public void clickSearchButton() {
		// searchBtn.click();
		b.clickOnElement(searchBtn, 15);
	}

}
