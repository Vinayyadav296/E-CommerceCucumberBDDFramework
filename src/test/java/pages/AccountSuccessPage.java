package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.Base;

public class AccountSuccessPage {
    
	Base b=new Base();
	public AccountSuccessPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//div[@id='content']//h1")
	private WebElement 	accountCreatedVerification;
    
	public String accountCreatedConfirmation() {
	  //	return accountCreatedVerification.getText();
		return b.getTextFromElement(accountCreatedVerification, 15);
	}
}
