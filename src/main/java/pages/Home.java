package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.Waits.elementWaitToVisble;

public class Home {
    private WebDriver driver;
    private By productSelectLoctor= By.xpath("//a[contains(text(), 'Samsung galaxy s6')]");
    private By addTocartbuttonLoctor=By.linkText("Add to cart");
    private By priceTextLoctor=By.cssSelector("h3.price-container");
    private By nameTextLoctor=By.xpath("//div[@id='tbodyid']/h2[1]");

    public Home(WebDriver driver)
    {
        this.driver=driver;

    }

    public void clickProduct()
    {
        elementWaitToVisble(driver,productSelectLoctor).click();
    }
    public void clickAddToCartButton()
    {

        elementWaitToVisble(driver,addTocartbuttonLoctor).click();
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
    public String getNameText()
    {
        return elementWaitToVisble(driver,nameTextLoctor).getText();
    }
    public String getPriceText()
    {
        return elementWaitToVisble(driver,priceTextLoctor).getText();
    }

}
