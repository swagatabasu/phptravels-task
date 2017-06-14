package com.blogspot.notes.automation.qa.pages;

import com.blogspot.notes.automation.qa.annotations.HTML;
import com.blogspot.notes.automation.qa.elements.*;
import com.blogspot.notes.automation.qa.interfaces.PageObjectsSupplier;
import com.blogspot.notes.automation.qa.wrappers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

import static com.blogspot.notes.automation.qa.elements.HTMLElement.SearchBy.*;
import static com.blogspot.notes.automation.qa.elements.HTMLElement.*;

public class LoginPage extends BasePage implements PageObjectsSupplier {

    @HTML(searchBy = NAME, value = "email")
    private TextInput inputEmail;

    @HTML(searchBy = NAME, value = "password")
    private TextInput inputPassword;

    @HTML(searchBy = XPATH, value = "//button[@class='btn btn-primary btn-block ladda-button fadeIn animated']")
    private Button loginButton;

    @HTML(searchBy = XPATH,value = "//a[@href='#ACCOUNTS']")
    private Link accountLink;

    @HTML(searchBy = XPATH,value = ".//*[@id='Accounts']/li[1]/a")
    private Link adminLink;

    @HTML(searchBy = XPATH, value = "//button[@class='btn btn-success']")
    private Button addButton;

    @HTML(searchBy = NAME, value = "fname")
    private TextInput firstName;

    @HTML(searchBy = NAME, value = "lname")
    private TextInput lastName;

    @HTML(searchBy = XPATH, value = ".//input[@name='mobile']")
    private TextInput mobileNo;

    @HTML(searchBy = XPATH, value = ".//input[@name='email']")
    private TextInput email;

    @HTML(searchBy = XPATH, value = ".//input[@name='password']")
    private TextInput password;


    @HTML(searchBy = XPATH, value = "//select[@name='country']")
    private Dropdown country;


    @HTML(searchBy = XPATH, value = "//button[@class='btn btn-primary']")
    private Button submitBtn;

    @HTML(searchBy = ID, value = "next")
    private Button buttonNext;

    @HTML(searchBy = ID, value = "signIn")
    private Button buttonSignIn;

    @HTML(searchBy = ID, value = "PersistentCookie")
    private CheckBox checkBoxStaySignedIn;

    public HomePage loginWith(final String email, final String password, final boolean staySignedIn) {
        return setEmail(email)
                .clickNext()
                .setPassword(password)
                .staySignedIn(staySignedIn)
                .signIn();
    }

    @Step("Type email = \"{0}\".")
    public LoginPage setEmail(final String email) {
        inputEmail.type(email);
        return this;
    }

    @Step("Type password = \"{0}\".")
    public LoginPage setPassword(final String password) {
        inputPassword.type(password);
        return this;
    }

    @Step("Set \"Stay signed in\" option = {0}.")
    public LoginPage staySignedIn(final boolean staySignedIn) {
        if (staySignedIn) {
            checkBoxStaySignedIn.check();
        } else {
            checkBoxStaySignedIn.unCheck();
        }
        return this;
    }

    @Step("Click \"Next\" button.")
    public LoginPage clickNext() {
        buttonNext.click();
        return this;
    }

    @Step("Click \"Sign in\" button.")
    public HomePage signIn() {
        loginButton.click();
        return homePage();
    }

    @Step("Click \"Accounts\" link")
    public HomePage clickAccounts() {
        accountLink.click();
        return homePage();
    }

    @Step("Wait for admin link")
    public HomePage waitForAdminLink() throws InterruptedException{

        return homePage();
    }

    @Step("Click on Admin link")
    public HomePage clickAdmin(){
        adminLink.click();
        return homePage();
    }

    @Step("Click on Add button")
    public HomePage clickAddButton(){
        addButton.click();
        return homePage();
    }

    @Step("Enter admin data")
    public LoginPage enterAdminData(String firstname,String lastname,String mobile,String text,String mail,String pwd) throws Throwable {
        firstName.type(firstname);
        lastName.type(lastname);
        email.type(mail);
        password.type(pwd);
        mobileNo.type(mobile);
        country.select(text);

        return this;
    }

    @Step("Submit new admin data")
    public LoginPage addAdmin()  {
       submitBtn.click();
        return this;
    }

    @Step("Type last name")
    public LoginPage setLastName(final String lastname) {
        lastName.type(lastname);
        return this;
    }

    @Step("Type phone number")
    public LoginPage setMobileNumber(final String mobile) {
        mobileNo.type(mobile);
        return this;
    }

    @Step("Select country")
    public LoginPage selectCountry(final String text) throws Throwable {
        country.select(text);
        return this;
    }

}
