package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;

import factory.BrowserFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStep {
	LoginPage loginpage; 
	@Given("user able to load application")
	public void user_able_to_load_application() {
	    // Write code here that turns the phrase above into concrete actions
	    loginpage=new LoginPage(BrowserFactory.getDriver());
	    
	}

	@When("User enter username as {string}, password as {string} and click on login button")
	public void user_enter_username_as_password_as_and_click_on_login_button(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
	    loginpage.loginToApplication(username, password);
	}

	@Then("User should able to login")
	public void user_should_able_to_login() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(BrowserFactory.getDriver().findElement(By.xpath("//span[text()='Manage']")).isDisplayed());
	}


}
