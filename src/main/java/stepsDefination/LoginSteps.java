package stepsDefination;

import base.BaseTest;


import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import pages.Login;
import utils.ExtentReportManger;

public class LoginSteps extends BaseTest {
    Login page;
    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
        setUp();

        page=new Login(driver);
        page.clickLogin();

    }
    @When("the user enters {string} and {string}")
    public void the_user_and(String userName, String password) {
        page.enterUserName(userName);
        page.enterPassword(password);
    }
    @And("the user clicks on login Button")
    public void the_user_click_on_l0gin_button() {
        page.clickLoginButton();
    }
    @Then("the user should see {string} for {string}")
    public void the_user_should_see_for(String expectedMessage, String type) {
        if (type.equalsIgnoreCase("valid")) {
            assertEquals(page.getLoginWelocmeMessege(), expectedMessage);
        } else {
            assertEquals(page.getAlertText(), expectedMessage);
        }
        close();




    }

}
