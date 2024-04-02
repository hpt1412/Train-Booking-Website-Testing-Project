package PageObjects.Railway;

import org.openqa.selenium.By;

public class LogoutPage extends GeneralPage {
    public LogoutPage open()
    {
        Constant.Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Account/Logout']"));
        return this;
    }
}
