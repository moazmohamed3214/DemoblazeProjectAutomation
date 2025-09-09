package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.Waits.elementWaitToVisble;

public class Payment {
    private WebDriver driver;
    private By placeOrderButton=By.xpath("//Button[text()='Place Order']");
    private By nameLoctor=By.id("name");
    private By countryLoctor=By.id("country");
    private By cityLoctor=By.id("city");
    private By creditCardLoctor=By.id("card");
    private By monthCardLoctor=By.id("month");
    private By yearCardLoctor=By.id("year");
    private By purchaseButton=By.xpath("//Button[text()='Purchase']");
    private By DonePaymentMessege=By.xpath("//h2[text()='Thank you for your purchase!']");
    public Payment(WebDriver driver)
    {
        this.driver=driver;
    }
    public void clickPlaceOrderButton()
    {
        elementWaitToVisble(driver,placeOrderButton).click();
    }
    public void enterName(String name)
    {
        elementWaitToVisble(driver,nameLoctor).sendKeys(name);
    }
    public void enterCountry(String country)
    {
        elementWaitToVisble(driver,countryLoctor).sendKeys(country);
    }
    public void enterCity(String city)
    {
        elementWaitToVisble(driver,cityLoctor).sendKeys(city);
    }
    public void enterCreditCard(String card)
    {
        elementWaitToVisble(driver,creditCardLoctor).sendKeys(card);
    }
    public void enterMonth(String month)
    {
        elementWaitToVisble(driver,monthCardLoctor).sendKeys(month);
    }
    public void enterYear(String year)
    {
        elementWaitToVisble(driver,yearCardLoctor).sendKeys(year);
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
    public void clickPurchaseButton()
    {
        elementWaitToVisble(driver,purchaseButton).click();
    }
    public String getDoneMessege()
    {
        return elementWaitToVisble(driver,DonePaymentMessege).getText();
    }





}
