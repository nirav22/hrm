package org.example;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepDefs
{
    LoginPage loginPage = new LoginPage();
    LoginSuccessPage loginSuccessPage = new LoginSuccessPage();


    @Given("^User is on Login Page$")
    public void user_is_on_Login_Page()
    { loginPage.verifyThatUserIsOnLoginPage(); }

    @When("^User Enters Valid Username And Password$")
    public void user_Enters_Valid_Username_And_Password()
    { loginPage.userEnterValidLoginDetails(); }

    @When("^User Clicks On Login Button$")
    public void user_Clicks_On_Login_Button()
    { loginPage.userClickOnLoginButton(); }

    @Then("^User Login Successfully$")
    public void user_Login_Successfully()
    {
        loginSuccessPage.verifyThatUserIsOnLoginSuccessPage();
        loginSuccessPage.userSeeTheWelcomePage();
    }



    @When("^User Enters Invalid \"([^\"]*)\" And \"([^\"]*)\"$")
    public void user_Enters_Invalid_And(String userName, String password)
    {
        loginPage.userEnterInvalidLoginDetails(userName,password);

    }

    @Then("^User see the \"([^\"]*)\"$")
    public void user_see_the(String errorMessage)
    {

        loginPage.userSeeTheErrorMessage(errorMessage);

    }

}
