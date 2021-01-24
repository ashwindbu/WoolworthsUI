package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonFunction {

    public static void explicitWait(String xpath, WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 60l);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static void explicitWaitUntilElementClickable(WebElement element, WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 60l);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void WebElementClick(String xpath , WebDriver driver)
    {
        try {
            WebElement ElementToClick = driver.findElement(By.xpath(xpath));
            CommonFunction.explicitWaitUntilElementClickable(ElementToClick, driver);
            ElementToClick.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
