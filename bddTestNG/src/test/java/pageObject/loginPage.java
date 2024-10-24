package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

	WebDriver driver;
	
	
	public loginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By txt_username = By.name("username");
	By txt_password = By.name("password");
	
	By btn_login = By.tagName("button");
	
	public void enterUsername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clickLoginBtn() {
		driver.findElement(btn_login).click();
	}

}
