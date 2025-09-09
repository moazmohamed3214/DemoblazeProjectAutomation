package stepsDefination;

import base.BaseTest;

import io.cucumber.java.en.*;
import org.openqa.selenium.devtools.v138.page.Page;
import static org.junit.Assert.*;
import pages.SignUp;

public class SignupSteps extends BaseTest {
    SignUp page;
    @Given("the user can on Signup page")
    public void the_user_can_on_signup_page() {
    setUp();
        page=new SignUp(driver);
        page.clickSignUp();

    }
    @When("the user enter {string} and {string}")
    public void the_user_enter_and(String userName, String password) {
        page.enterUserName(userName);
        page.enterPassword(password);
    }    @And("click on sinup button")
    public void click_on_sinup_button() {
        page.clickSignUpButton();
    }
    @Then("the user should see {string} on signup")
    public void the_user_should_see_for(String expectedMessage) {

        try
        {
            assertEquals(page.geAlertText(), expectedMessage);
        }
        finally {
            close();
        }


    }
}
