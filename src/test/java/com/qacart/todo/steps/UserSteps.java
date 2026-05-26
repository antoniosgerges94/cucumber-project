package com.qacart.todo.steps;

import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.steps.factory.DriverFactory;
import com.qacart.todo.utils.EnvUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

import java.io.IOException;

public class UserSteps {

    WebDriver driver;

    @Given("User is at the login page")
    public void user_is_at_the_login_page() throws IOException {
        // Remove EdgeOptions and DriverFactory.getDriver() from here
        driver = DriverFactory.getDriver(); // just fetch the already-initialized driver
        new LoginPage(driver).load(EnvUtils.getInstance().getURL() + "/login");
    }

    @When("User fill the email and password fields then login")
    public void user_fill_the_email_and_password_fields_then_login() throws IOException {
        new LoginPage(driver).login(EnvUtils.getInstance().getEmail(), EnvUtils.getInstance().getPassword());
    }

    @Then("Welcome message should be displayed")
    public void welcome_message_should_be_displayed() {
        boolean isWelcomeDisplayed = new TodoPage(driver).isWelcomeDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);
    }
}