package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static utils.Waits.elementWaitToVisble;


public class SignUp {
    private WebDriver driver;
    private By signUpButtonHomeLoctor= By.id("signin2");
    private By userNameFieldLoctor=By.xpath("//input[@id='sign-username']");
    private By passwordFieldLoctor=By.xpath("//input[@id='sign-password']");
    private By getSignUpButtonLoctor= By.xpath("//button[text()='Sign up']");
    public SignUp(WebDriver driver)
    {
        this.driver=driver;

    }
    public void clickSignUp()
    {

        elementWaitToVisble(driver,signUpButtonHomeLoctor).click();
    }
    public void enterUserName(String name)
    {
        elementWaitToVisble(driver,userNameFieldLoctor).sendKeys(name);

    }
    public void enterPassword(String password)
    {
        elementWaitToVisble(driver,passwordFieldLoctor).sendKeys(password);

    }
    public void clickSignUpButton()
    {

        elementWaitToVisble(driver,getSignUpButtonLoctor).click();
    }
    public String  geAlertText()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent()); // wait until alert is there

        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;

    }





}
