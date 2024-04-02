package PageObjects.Railway;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class CongraPage extends GeneralPage  {
    private final By _CongraMsg = By.xpath("//div[@id='content']/p");
    public WebElement getCongraMsg()
    {
        return Constant.WEBDRIVER.findElement((_CongraMsg));
    }
}
