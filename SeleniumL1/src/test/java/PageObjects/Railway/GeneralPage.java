package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;
public class GeneralPage{
    //Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By IblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By tabChangePW = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");

    //Elements
    protected WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabRegister(){
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTabLogout(){ return Constant.WEBDRIVER.findElement(tabLogout);}
    protected WebElement getLblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(IblWelcomeMessage);
    }
    protected WebElement getTabBookTicket() {return Constant.WEBDRIVER.findElement(tabBookTicket);}
    protected WebElement getTabMyTicket() {return Constant.WEBDRIVER.findElement(tabMyTicket);}
    protected WebElement getTabChangePW() {return Constant.WEBDRIVER.findElement(tabChangePW);}
    //Methods
    public String getWelcomeMessage()
    {
        return this.getLblWelcomeMessage().getText();
    }
    public LoginPage gotoLoginPage()
    {
        this.getTabLogin().click();
        return new LoginPage();
    }
    public RegisterPage gotoRegisterPage()
    {
        this.getTabRegister().click();
        return new RegisterPage();
    }
    public LoginPage gotoBookTicketPage()
    {
        this.getTabBookTicket().click();
        return new LoginPage();
    }
    public boolean isMyTicketDisplayed() {
            return getTabMyTicket().isDisplayed();
        }

    public boolean isChangePWDisplayed() {
        return getTabChangePW().isDisplayed();
    }

    public boolean isLogoutDisplayed() {
            return getTabLogout().isDisplayed();
    }
    public ChangePW gototoChangePW(){
        this.getTabChangePW().click();
        return new ChangePW();
    }

}
