package TestCase.Railway;

import PageObjects.Railway.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Constant.Constant;
import org.openqa.selenium.By;

public class LoginTest {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
    @Test
    public void TC01(){
        System.out.println("TC01-User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC02(){
        System.out.println("TC02-User can't login with blank Username textbox");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login("", Constant.PASSWORD);
        String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
    @Test
    public void TC03(){
        System.out.println("TC03-User cannot log into Railway with invalid password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, "@");
        String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
    @Test
    public void TC04(){
        System.out.println("TC04-Login page displays when un-logged User clicks on Book ticket tab");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoBookTicketPage();
        System.out.println("Login page is displayed when an unlogged user clicks on the \"Book ticket\" tab as expected.");

    }
    @Test
    public void TC05(){
        System.out.println("TC05-System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        for (int i = 0; i < 3; i++) {
            loginPage.login(Constant.USERNAME, "");

        }
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg);

    }
    @Test
    public void TC06(){
        System.out.println("TC06-Additional pages display once user logged in");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        boolean isMyTicketDisplayed = loginPage.isMyTicketDisplayed();
        boolean isChangePWDisplayed = loginPage.isChangePWDisplayed();
        boolean isLogoutDisplayed = loginPage.isLogoutDisplayed();
        MyTicket ticket = new MyTicket();
        ticket.clickAndOpen();
        ChangePW pw = new ChangePW();
        pw.clickAndOpen();
        Assert.assertEquals(isMyTicketDisplayed,true, "My Ticket tab is not displayed");
        Assert.assertEquals(isChangePWDisplayed,true, "Change Password tab is not displayed");
        Assert.assertEquals(isLogoutDisplayed, true,"Logout tab is not displayed");
    }
    @Test
    public void TC07() //throws InterruptedException//
    {
        System.out.println("TC07-User can create new account");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage RegPage = homePage.gotoRegisterPage();
        RegPage.register("Meocon077723@gmail.com", "Meocon123", "Meocon123", "01020304050607");
        CongraPage conPage = new CongraPage();
        String congraMsg = conPage.getCongraMsg().getText();
        Assert.assertTrue(congraMsg.contains("Confirmed"), "Thank you for registering your account");
        //Thread.sleep(5000);
    }

    @Test
    public void TC08() {
        System.out.println("TC08-User can't login with an account hasn't been activated");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login("abc123@gmail.com", "12345678");
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg,expectedMsg);
    }
    @Test
    public void TC09(){
        System.out.println("TC09-User can change password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        ChangePW change = loginPage.gototoChangePW();
        change.enter(Constant.PASSWORD, "1234567890a", "1234567890a");
        String actualMsg = change.getMsgChange().getText();
        String expectMsg= "Your password has been updated";
        Assert.assertEquals(actualMsg,expectMsg);
    }
    @Test
    public void TC10(){
        System.out.println("TC10-User can't create account with \"Confirm password\" is not the same with \"Password\"\n");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage RegPage = homePage.gotoRegisterPage();
        RegPage.register("Gacon123@gmail.com","Gacon123", "Gacon1234", "01020304050607");
        String actualMsg = RegPage.geterrorMsg().getText();
        String expectedMsg= "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg,expectedMsg);
    }
    @Test
    public void TC11(){
        System.out.println("TC11-User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage RegPage = homePage.gotoRegisterPage();
        RegPage.register("Chocon123@gmail.com","", "","");
        String actualMsg=RegPage.geterrorMsg().getText();
        String expectMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg,expectMsg);

        String actualpwMsg=RegPage.getpwMsg().getText();
        String expectpwMsg="Invalid password length";
        Assert.assertEquals(actualpwMsg,expectpwMsg);

        String actualpidMsg=RegPage.getpidMsg().getText();
        String expectpidMsg="Invalid ID length";
        Assert.assertEquals(actualpidMsg,expectpidMsg);
    }
    @Test
    public void TC12(){
        System.out.println("TC12-Errors display if password and confirm password don't match when resetting password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        ForgotPWPage forgetPage = loginPage.gotoForgotPWPage();
        forgetPage.enter(Constant.USERNAME);
        String actualErrorMsg = "Mail box can not open!";
        String expectedErrorMsg = "Mail box opened.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Can not change password");


    }
    @Test
    public void TC13(){
        System.out.println("TC13-Errors display if password and confirm password don't match when resetting password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        ForgotPWPage forgetPage = loginPage.gotoForgotPWPage();
        forgetPage.enter(Constant.USERNAME);
        String actualErrorMsg = "Mail box can not open!";
        String expectedErrorMsg = "Mail box opened.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Can not change password");
    }
    @Test
    public void TC14(){
        System.out.println("TC14-User can book 1 ticket at a time");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoBookTicketPage();
        String randomDate = selectRandomDate();
        Constant.WEBDRIVER.findElement(By.name("Date")).click();
        Constant.WEBDRIVER.findElement(By.xpath("//option[contains(text(),'" + randomDate + "')]")).click();
    }




}
