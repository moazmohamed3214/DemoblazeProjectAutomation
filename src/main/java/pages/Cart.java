package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Waits.elementWaitToVisble;

public class Cart {
    private WebDriver driver;
    private By cartNavigationLoctor=By.id("cartur");
    private By priceLoctor=By.xpath("//tr/td[3]");
    private By nameProductLoctor=By.xpath("//tr/td[2]");
    private By deleteButtonLoctor=By.xpath("//tr/td[4]/a[text()='Delete']");
    public Cart(WebDriver driver)
    {
        this.driver=driver;

    }

    public void clickcartNavigationLink()
    {

        elementWaitToVisble(driver,cartNavigationLoctor).click();
    }
    public String getProductPriceText()
    {
        return elementWaitToVisble(driver,priceLoctor).getText();
    }
    public String getProductNameText()
    {
        return elementWaitToVisble(driver,nameProductLoctor).getText();
    }
    public void clickDeleteButton()
    {
        elementWaitToVisble(driver,deleteButtonLoctor).click();
    }

}
