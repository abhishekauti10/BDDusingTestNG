package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	WebDriver driver;
	
	//CONSTRUCTOR
	public LoginPageFactory(WebDriver driver) {
		this.driver= driver;
		
		// Initialize elements using PageFactory
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name = "username")
	WebElement txt_username;
	
	@FindBy(name = "password")
	WebElement txt_password;
	
	@FindBy(tagName = "button")
	WebElement btn_login;
	
	public void enterUN(String username) {
		txt_username.sendKeys(username);
	}
	
	public void enterPS(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickLB() {
		btn_login.click();
	}
	
	
	
	

}
