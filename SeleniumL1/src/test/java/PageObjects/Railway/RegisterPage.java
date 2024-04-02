package PageObjects.Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{
    //Locators
    private final By _txtEmail = By.xpath("//input[@id='email']");
    private final By _txtPassword = By.xpath("//input[@id='password']");

    private final By _txtConfirm = By.xpath("//input[@id='confirmPassword']");
    private final By _txtPid = By.xpath("//input[@id='pid']");
    private final By _btnRegister = By.xpath("//input[@value='Register']");
    private final By errorMsg = By.xpath("//p[@class='message error']");
    private final By pwMsg = By.xpath("//*[@id=\"RegisterForm\"]/fieldset/ol/li[2]/label[2]");
    private final By pidMsg = By.xpath("//*[@id=\"RegisterForm\"]/fieldset/ol/li[4]/label[2]");
    //elements
    public WebElement getTxtEmail()
    {
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getTxtPassword()
    {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getTxtConfirm()
    {
        return Constant.WEBDRIVER.findElement(_txtConfirm);
    } public WebElement getPid()
    {
        return Constant.WEBDRIVER.findElement(_txtPid);
    }
    public WebElement getBtnRegister()
    {
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }
    public WebElement geterrorMsg() { return Constant.WEBDRIVER.findElement(errorMsg);}
    public WebElement getpwMsg() { return Constant.WEBDRIVER.findElement(pwMsg);}
    public WebElement getpidMsg() { return Constant.WEBDRIVER.findElement(pidMsg);}



    //method
    public CongraPage register(String email, String pw, String cfpw, String pid) {
        //submit
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(pw);
        this.getTxtConfirm().sendKeys(cfpw);
        this.getPid().sendKeys(pid);
        this.getBtnRegister().click();
        return new CongraPage();
    }
}
