package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class POMPositiveAndNegativeLogin {


	WebDriver driver = new ChromeDriver();
	LoginPage login = new LoginPage(driver);

	@Given("^user is on the the internet page$")
	public void user_is_on_the_the_internet_page(){


		driver.get("https://the-internet.herokuapp.com/login");

	}


	@When("^title of login page is The Internet$")
	public void title_of_login_page_is_the_internet(){

		String title = driver.getTitle();
		System.out.println(title);

		Assert.assertEquals("The Internet", title);
	}


	@Then("^user enters \"(.+)\" and \"(.+)\"$")					// Using RegEx
	public void user_enters_username_and_password(String username,String password){
		
		
		login.enterUsername(username);
		login.enterPassword(password);

	}


	@And("^user clicks on login button first$")
	public void user_clicks_on_login_button_first() throws InterruptedException{

		login.clickLoginBtn();
	}


	@Then("^user lands on home page$")
	public void user_lands_on_home_page() throws InterruptedException {

		String expectedStr = "You logged into a secure area!\n×";

		WebElement errorMessage = driver.findElement(By.id("flash"));

		String actualStr = errorMessage.getText();

		Assert.assertEquals(expectedStr, actualStr);
		//expectedStr1.equals(actualStr2);

		System.out.println("login success "+ actualStr);

		driver.quit();
	}


	@When("^user enters correct (.*) but (.*)")
	public void user_enters_correct_username_but_password(String username,String password) {
		login.enterUsername(username);
		login.enterPassword(password);
	}


	@And("^user clicks on login button second$")
	public void user_clicks_on_login_button_second() {
		login.clickLoginBtn();
	}


	@Then("^user login fail with error message at the top one$")
	public void user_login_fail_with_error_message_at_the_top_one() {

		String expectedStr1 = "Your username is invalid!\n×";

		WebElement errorMessage = driver.findElement(By.id("flash"));

		String actualStr2 = errorMessage.getText();

		Assert.assertEquals(expectedStr1, actualStr2);
		//expectedStr1.equals(actualStr2);

		System.out.println("You cannot login as "+ actualStr2);

		driver.quit();

	}


	@When("^user enters wrong (.*) and (.*)")
	public void user_enters_wrong_username_and_password(String username,String password) {

		login.enterUsername(username);
		login.enterPassword(password);
	}


	@And("^user clicks on login button third$")
	public void user_clicks_on_login_button_third() {
		login.clickLoginBtn();
	}


	@Then("^user login fail with error message at the top two$")
	public void user_login_fail_with_error_message_at_the_top_two() {

		String expectedStr1 = "Your password is invalid!\n×";

		WebElement errorMessage = driver.findElement(By.id("flash"));

		String actualStr2 = errorMessage.getText();

		Assert.assertEquals(expectedStr1, actualStr2);
		//expectedStr1.equals(actualStr2);

		System.out.println("You cannot login as "+ actualStr2);

		driver.manage().deleteAllCookies();

		driver.quit();

	}

}
