package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends Util
{
    LoadProp loadProp = new LoadProp();

    String expectedTitleOfLoginPage="LOGIN Panel";
    private By _actualTitleOfThePage = By.id("logInPanelHeading");
    private By _userName = By.id("txtUsername");
    private By _Password = By.id("txtPassword");
    private By _clickOnLoginButton = By.id("btnLogin");

    public void verifyThatUserIsOnLoginPage ()
    {
        asserttextmessage(getTextFromElement(_actualTitleOfThePage),expectedTitleOfLoginPage,"User Is Not Login Page");
    }

    public void userEnterValidLoginDetails ()
    {
        typeText(_userName,loadProp.getProperty("Username"));
        typeText(_Password,loadProp.getProperty("Password"));
    }

    public void userClickOnLoginButton()
    { clickOnElement(_clickOnLoginButton); }


    public void userEnterInvalidLoginDetails(String userName,String password)
    {
        //type text from feature file
        typeText(By.ByCssSelector.id("txtUsername"), userName);
        //type text from feature file
        typeText(By.ByCssSelector.id("txtPassword"), password);
    }


    public void userSeeTheErrorMessage(String errorMessage)
    {

        Assert.assertEquals(getTextFromElement(By.id("spanMessage")), errorMessage, "User Not Login With Invalid Attempt !!!");
        //sout print get text value
        System.out.println(getTextFromElement(By.ByCssSelector.id("spanMessage")));

    }
}