package PageObjects.Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPWPage extends GeneralPage{
    //locators
    private final By _txtEmail = By.xpath("//input[@id='email']");
    private final By _btnSend = By.xpath("//input[@value='Send Instructions']");
    //elements
    public WebElement getEmail()
    {
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getbtnSend()
    {
        return Constant.WEBDRIVER.findElement(_btnSend);
    }
    //method
    public ForgotPWPage enter(String email) {
        this.getEmail().sendKeys(email);
        this.getbtnSend().click();
        return new ForgotPWPage();
    }
}
