package com.gtech.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {



    @AndroidFindBy(xpath = "//*[@text='GET STARTED']")
    private WebElement btnGetStarted;

    @AndroidFindBy (className = "android.widget.EditText")
    private WebElement txtTelephoneNum;

    @AndroidFindBy (xpath = "//*[@text='Login With Password']")
    private WebElement btnLoginByPasswd;

    @AndroidFindBy (xpath = "//*[@text='* * * * * * *']")
    private WebElement txtPasswd;

    @AndroidFindBy (xpath = "//*[@text='LOGIN']")
    private WebElement btnLogin;



    public LoginPage(){

    }


    public LoginPage pressGetStartedBtn() throws InterruptedException {
        click(btnGetStarted, "press Get started button");
        return this;

    }

    public LoginPage enterTelephoneNum(String telephoneNum) throws InterruptedException {

        clear(txtTelephoneNum);
        sendKeys(txtTelephoneNum, telephoneNum, "login with " + telephoneNum);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(txtPasswd, password, "password is " + password);
        return this;
    }

    public LoginPage pressLoginWithPasswd() {
        click(btnLoginByPasswd, "press login with password button");
        return this;
    }



    public HomePage pressLoginBtn() {
        click(btnLogin, "press login button");
        return new HomePage();
    }


}
