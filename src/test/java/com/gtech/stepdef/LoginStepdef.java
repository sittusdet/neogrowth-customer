package com.gtech.stepdef;

import com.gtech.pages.LoginPage;
import com.gtech.pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdef {
    
    
    @When("I click on Get Started")
    public void iClickOnGetStarted() throws InterruptedException {
        new LoginPage().pressGetStartedBtn();
    }

    @And("I click on Login")
    public void iClickOnLogin() throws InterruptedException {

        new LoginPage().pressLoginBtn();
        
    }


    @And("I enter telephone number as {string}")
    public void iEnterTelephoneNumberAs(String telephoneNum) throws InterruptedException {

        new LoginPage().enterTelephoneNum(telephoneNum);

    }

    @And("I enter the password as {string}")
    public void iEnterThePasswordAs(String passwd) throws InterruptedException {

        new LoginPage().enterPassword(passwd);
    }

    @Then("I should see home page with title {string}")
    public void iShouldSeeHomePageWithTitle(String arg0) {
        //new BasePage().waitForVisibility(string);
    }

    @And("I click on Login with Password")
    public void iClickOnLoginWithPassword() throws InterruptedException {

        new LoginPage().pressLoginWithPasswd();
    }
}
