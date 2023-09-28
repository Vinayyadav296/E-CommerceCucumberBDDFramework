package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.Base;

//public class RegisterPage extends Base {

public class RegisterPage {

	Base b = new Base();

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#input-firstname")
	private WebElement firstNameField;

	@FindBy(css = "input#input-lastname")
	private WebElement lastNameField;

	@FindBy(css = "input#input-email")
	private WebElement emailField;

	@FindBy(css = "input#input-telephone")
	private WebElement telephoneField;

	@FindBy(css = "input#input-password")
	private WebElement passwordField;

	@FindBy(css = "input#input-confirm")
	private WebElement confirmpasswordField;

	@FindBy(css = "input[name='agree']")
	private WebElement privacyPolicy;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueBtn;

	@FindBy(css = "input[name='newsletter'][value='1']")
	private WebElement newLetteBox;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement dulplicateEmail;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement inputEmailWarning;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement inputTelephoneWarning;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement inputPasswordWarning;

	public void enterFirstName(String firstNameText) {
		// firstNameField.sendKeys(firstNameText);
		b.typeTextIntoElement(firstNameField, firstNameText, Base.wait_Time);
	}

	public void enterLastName(String lastNameText) {
		// lastNameField.sendKeys(lastNameText);
		b.typeTextIntoElement(lastNameField, lastNameText, Base.wait_Time);
	}

	public void enterEmailField(String emailText) {
		// emailField.sendKeys(emailText);
		b.typeTextIntoElement(emailField, emailText, Base.wait_Time);
	}

	public void enterTelephone(String telephoneText) {
		// telephoneField.sendKeys(telephoneText);
		b.typeTextIntoElement(telephoneField, telephoneText, Base.wait_Time);
	}

	public void enterPassword(String passwordText) {
		// passwordField.sendKeys(passwordText);
		b.typeTextIntoElement(passwordField, passwordText, Base.wait_Time);
	}

	public void enterConfirmPassword(String confirmPasswordText) {
		// confirmpasswordField.sendKeys(confirmPasswordText);
		b.typeTextIntoElement(confirmpasswordField, confirmPasswordText, Base.wait_Time);
	}

	public void selectPrivacyPolicy() {
		// privacyPolicy.click();
		b.clickOnElement(privacyPolicy, Base.wait_Time);
	}

	public void clickContinueBtn() {
		// continueBtn.click();
		b.clickOnElement(continueBtn, Base.wait_Time);
	}

	public void clickYesForNewsLetter() {
		// newLetteBox.click();
		b.clickOnElement(newLetteBox, Base.wait_Time);
	}

	public String duplicateEmailWarning() {
 	//	return dulplicateEmail.getText();
	  return b.getTextFromElement(dulplicateEmail, Base.wait_Time);
	}

	public String getFirstNameWarning() {
		// return firstNameWarning.getText();
		return b.getTextFromElement(firstNameWarning, Base.wait_Time);
	}

	public String getlastNameWarning() {
		// return lastNameWarning.getText();
		return b.getTextFromElement(lastNameWarning, Base.wait_Time);
	}

	public String getEmailWarning() {
		// return inputEmailWarning.getText();
		return b.getTextFromElement(inputEmailWarning, Base.wait_Time);
	}

	public String getTelephoneWarning() {
		// return inputTelephoneWarning.getText();
		return b.getTextFromElement(inputTelephoneWarning, Base.wait_Time);
	}

	public String getPasswordWarning() {
		// return inputPasswordWarning.getText();
		return b.getTextFromElement(inputPasswordWarning, Base.wait_Time);
	}

//	public void user_navigates_to_the_register_account_page() {
//		 driver.findElement(By.xpath("//span[.='My Account']")).click();
//         driver.findElement(By.linkText("Register")).click();
//	}

//	public void user_enters_the_details_in_below_fields(DataTable dataTable) {
//		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
//		driver.findElement(By.cssSelector("input#input-firstname")).sendKeys(dataMap.get("firstName"));
//		driver.findElement(By.cssSelector("input#input-lastname")).sendKeys(dataMap.get("lastName"));
//		driver.findElement(By.cssSelector("input#input-email")).sendKeys(dataMap.get("email"));
//		driver.findElement(By.cssSelector("input#input-telephone")).sendKeys(dataMap.get("telephone"));
//		driver.findElement(By.cssSelector("input#input-password")).sendKeys(dataMap.get("password"));
//		driver.findElement(By.cssSelector("input#input-confirm")).sendKeys(dataMap.get("password"));
//
//	}

//	public void user_clicks_on_privacy_policy() {
//		driver.findElement(By.cssSelector("input[name='agree']")).click();
//	}

//	public void user_clicks_on_continue_button() {
//		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
//	}

//	public void user_account_should_created_successfully() {
//		Assert.assertEquals("Your Account Has Been Created!",
//				driver.findElement(By.xpath("//div[@id='content']//h1")).getText());
//	}

//	public void user_select_yes_for_news_letter() {
//		driver.findElement(By.cssSelector("input[name='newsletter'][value='1']")).click();
//	}

//	public void user_should_get_a_warning_message_about_duplicate_email() {
//		String warningMsg = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
//		Assert.assertEquals("Warning: E-Mail Address is already registered!", warningMsg);
//	}

//	public void user_enters_the_details_in_below_fields() {
//	   
//	}

	public void user_does_not_filled_any_details_into_the_fields() {
		// Kept intentionally blanked
	}

//	public void user_should_get_a_warning_message_for_filling_every_mandatory_fields() {
//		Assert.assertEquals("Warning: You must agree to the Privacy Policy!",
//				driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText());
//		Assert.assertEquals("First Name must be between 1 and 32 characters!",
//				driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());
//		Assert.assertEquals("Last Name must be between 1 and 32 characters!",
//				driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
//		Assert.assertEquals("E-Mail Address does not appear to be valid!",
//				driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
//		Assert.assertEquals("Telephone must be between 3 and 32 characters!",
//				driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
//		Assert.assertEquals("Password must be between 4 and 20 characters!",
//				driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());
//
//	}
}
