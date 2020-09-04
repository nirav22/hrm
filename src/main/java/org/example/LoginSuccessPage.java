package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginSuccessPage extends Util
{
    String expectedTitleOfLoginSuccessPage="Welcome Linda";
    private By _actualTitleOfTheLoginSuccessPage = By.id("welcome");


    public void verifyThatUserIsOnLoginSuccessPage ()
    {
        assertURL("dashboard");
    }

    public void userSeeTheWelcomePage ()
    {
        asserttextmessage(getTextFromElement(_actualTitleOfTheLoginSuccessPage),expectedTitleOfLoginSuccessPage,"User is not login success page");
        takeScreenShot("abc");
    }
}
