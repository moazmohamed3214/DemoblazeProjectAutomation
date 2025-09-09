package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

import static utils.Waits.elementWaitToVisble;

public class Login {
    private WebDriver driver;
    private By login=By.xpath("//a[text()='Log in']");
    private By userNameField=By.id("loginusername");
    private By passwordField=By.id("loginpassword");
    private By loginButton=By.xpath("//button[text()='Log in']");
    private By loginWelcomeMessege=By.id("nameofuser");
    public Login(WebDriver driver)
    {
        this.driver=driver;

    }

    public void clickLogin()
    {
        elementWaitToVisble(driver,login).click();

    }
    public void enterUserName(String name)
    {
        elementWaitToVisble(driver,userNameField).sendKeys(name);

    }
    public void enterPassword(String password)
    {
        elementWaitToVisble(driver,passwordField).sendKeys(password);

    }
    public void clickLoginButton()
    {

        elementWaitToVisble(driver,loginButton).click();
    }
    public String getAlertText()
    {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        String text=alert.getText();
        alert.accept();
        return text;
    }
    public String getLoginWelocmeMessege()
    {
        String text=elementWaitToVisble(driver,loginWelcomeMessege).getText();
        return text;
    }





}
