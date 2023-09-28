package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.Base;

public class LoginPage   {
	
	  Base b=new Base();
	
	    public  LoginPage(WebDriver driver){
	    	 PageFactory.initElements(driver, this);
	     }
	     
//	    @FindBy(xpath="//span[.='My Account']")
//	    private WebElement myAccountDropDownMenu;
//	    
//	    @FindBy(linkText = "Login")
//	    private WebElement loginOption;
	    
	    @FindBy(css="input#input-email")
        private WebElement emailField;
	    
	    @FindBy(css="input#input-password")
	    private WebElement passwordField;
	    
	    @FindBy(css="input.btn.btn-primary")
	    private WebElement loginButton;
	    
	    @FindBy(xpath="//div[@id='content']//h2")
	    private WebElement accountPage;
	    
	    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	    private WebElement warningMsg;
	    
//	    public void clickOnMyAccount() {
//	    	myAccountDropDownMenu.click();
//	    }
//	    
//	   	   
//	    public void selectLoginOption() {
//	    	loginOption.click();
//	    }
	    
	   	    
	    public void enterEmail(String email) {
	    	//emailField.sendKeys(email);
	    	b.typeTextIntoElement(emailField, email, 15);
	    }
	    
	   	    
	    public void enterPassword(String password) {
	    	//passwordField.sendKeys(password);
	    	b.typeTextIntoElement(passwordField, password, 15);
	    }
	    
	    public void clickOnLoginButton() {
	      // loginButton.click();
	       b.clickOnElement(loginButton, 15);
	    }
	    
	    public boolean verifyAccountPage() {
	    	return accountPage.isDisplayed();
	    }
	    
	    public String getWarningMsg() {
	      //  return warningMsg.getText();
	      return b.getTextFromElement(warningMsg, 15);
	    }
	    
	    
	    
	    
//	    LoginPage l=new LoginPage();
    
//		public void user_navigate_to_the_login_page() {
//		driver.findElement(By.xpath("//span[.='My Account']")).click();
//		driver.findElement(By.linkText("Login")).click();
//		
//		
//	}
//
//		public void user_enter_the_valid_email_address_into_email_field(String email) {
//		driver.findElement(By.cssSelector("input#input-email")).sendKeys(email);
//
//	}
//
//		public void user_enter_the_valid_password_into_the_password_field(String password) {
//		driver.findElement(By.cssSelector("input#input-password")).sendKeys(password);
//	}
//
//		public void user_clicks_on_the_login_button() {
//		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
//	}
//
//		public void user_should_be_able_to_login_successfully() {
//
//		WebElement myAccount = driver.findElement(By.xpath("//div[@id='content']//h2"));
//		Assert.assertTrue(myAccount.isDisplayed());
//	}
//
//		public void user_enter_the_invalid_email_address_into_email_field(String invalidEmailText) {
//		driver.findElement(By.cssSelector("input#input-email")).sendKeys(invalidEmailText);
//	}
//
//		public void user_enter_the_invalid_password_into_the_password_field(String invalidPasswordText) {
//		driver.findElement(By.cssSelector("input#input-password")).sendKeys(invalidPasswordText);
//	}
//
//		public void user_should_get_proper_warning_message_of_invalid_credentials() {
//		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText()
//				.contains("Warning: No match for E-Mail Address and/or Password."));
//	}
//
//		public void user_should_get_the_warning_message_of_the_invalid_password() {
//
//	}
//
//		public void user_should_get_the_warning_message_of_the_invalid_email() {
//
//	}
//	
//		public void user_does_not_provide_any_email_address_in_the_email_field() {
//		driver.findElement(By.cssSelector("input#input-email")).sendKeys(" ");
//	}
//
//		public void user_does_not_provide_any_password_in_the_password_field() {
//		driver.findElement(By.cssSelector("input#input-password")).sendKeys("");
//	}
//		
//		public void user_should_get_the_warning_message_of_enter_email_and_password() {
//		  String msg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
//		  Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", msg);
//		}
	
}
