package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.Waits.elementWaitToVisble;

public class Contact {
    private WebDriver driver;
    private By contactLoctor=By.xpath("//a[text()='Contact']");
    private By contactEmailLoctor=By.id("recipient-email");
    private By contactNameLoctor=By.xpath("//input[@id='recipient-name']");
    private By contactMessageLoctor=By.xpath("//textarea[@id='message-text']");
    private By sendMessegeButtonLoctor=By.xpath("//button[text()='Send message']");
    public Contact(WebDriver driver)
    {
        this.driver=driver;
    }
    public void clickContact()
    {
        elementWaitToVisble(driver,contactLoctor).click();
    }
    public void entercontactEmail(String email)
    {
        elementWaitToVisble(driver,contactEmailLoctor).sendKeys(email);
    }
    public void entereName(String name)
    {
        elementWaitToVisble(driver,contactNameLoctor).sendKeys(name);
    }

    public void enterMessege(String messege)
    {
        elementWaitToVisble(driver,contactMessageLoctor).sendKeys(messege);
    }
    public void clickSendMessege()
    {
        elementWaitToVisble(driver,sendMessegeButtonLoctor).click();
    }
    public String getAlertText()
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        String text=alert.getText();
        alert.accept();
        return text;
    }

}
