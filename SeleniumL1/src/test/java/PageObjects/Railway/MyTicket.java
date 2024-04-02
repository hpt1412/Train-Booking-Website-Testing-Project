package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicket extends GeneralPage {
    public MyTicket clickAndOpen()
    {
        WebElement myTicketTab = Constant.Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']"));
        myTicketTab.click();
        return new MyTicket();
    }
}
