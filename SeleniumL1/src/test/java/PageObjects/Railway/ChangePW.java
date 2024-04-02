package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePW extends GeneralPage {
    private final By currentPW = By.xpath("//input[@id='currentPassword']");
    private final By newPW = By.xpath("//input[@id='newPassword']");
    private final By confirmPW = By.xpath("//input[@id='confirmPassword']");
    private final By btnChange = By.xpath("//input[@value='Change Password']");
    private final By MsgChange = By.xpath("//p[@class='message success']");
    //elements
    public WebElement getcurrentPW()
    {
        return Constant.Constant.WEBDRIVER.findElement(currentPW);
    }
    public WebElement getnewPW()
    {
        return Constant.Constant.WEBDRIVER.findElement(newPW);
    }
    public WebElement getconfirmPW()
    {
        return Constant.Constant.WEBDRIVER.findElement(confirmPW);
    }
    public WebElement getbtnChange()
    {
        return Constant.Constant.WEBDRIVER.findElement(btnChange);
    }
    public WebElement getMsgChange()
    {
        return Constant.Constant.WEBDRIVER.findElement(MsgChange);
    }


    public ChangePW enter( String current, String newpw, String cfpw){
        this.getcurrentPW().sendKeys(current);
        this.getnewPW().sendKeys(newpw);
        this.getconfirmPW().sendKeys(cfpw);
        this.getbtnChange().click();
        return new ChangePW();
    }



    public ChangePW clickAndOpen()
    {
        WebElement ChangePWTab = Constant.Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']"));
        ChangePWTab.click();
        return new ChangePW();
    }

}
