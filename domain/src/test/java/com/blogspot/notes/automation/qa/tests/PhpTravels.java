package com.blogspot.notes.automation.qa.tests;

import com.blogspot.notes.automation.qa.interfaces.ScreenElement;
import com.blogspot.notes.automation.qa.interfaces.TestCase;
import com.blogspot.notes.automation.qa.pages.HomePage;
import com.blogspot.notes.automation.qa.pages.LoginPage;
import com.blogspot.notes.automation.qa.wrappers.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PhpTravels extends BaseTest implements TestCase {

    @BeforeMethod
    void mockSikuliElements() {
        ScreenElement input = mock(ScreenElement.class);
        ScreenElement button = mock(ScreenElement.class);
        when(getSikuliDriver().findElement("inputFilePath.png", 0.8f)).thenReturn(input);
        when(getSikuliDriver().findElement("buttonUpload.png", 0.8f)).thenReturn(button);
        doNothing().when(input).type("path");
        doNothing().when(button).click();
    }

    @Test
    public void AddNewAdminAndVerify() throws Throwable {
        loadUrl("http://www.phptravels.net/admin")
                .setEmail("admin@phptravels.com")
                .setPassword("demoadmin")
                .signIn();

        TimeUnit.SECONDS.sleep(2);
        loginPage().clickAccounts();
        loginPage().clickAdmin();
        loginPage().clickAddButton();

        String email= randomString()+"@phptravels.com";
        loginPage().enterAdminData("Jane","Doe","075765656588","United Kingdom",email,"demoadmin");

        WebElement temp= getWebDriver().findElement(By.xpath("//input[@value='addTours']"));
        WebElement tourBox = temp.findElement(By.xpath("following-sibling::*[1]"));

        tourBox.click();
        loginPage().addAdmin();

        TimeUnit.SECONDS.sleep(3);

        try{
            getWebDriver().findElement(By.linkText(email));
            System.out.println("New admin user addition successful");
        }catch(NoSuchElementException e){
            System.out.println("New admin user addition unsuccessful");
        }

        getWebDriver().findElement(By.xpath("//a[@title='Edit'][1]")).click();
        TimeUnit.SECONDS.sleep(3);

        try{
            getWebDriver().findElement(By.xpath("//input[@checked='']"));
            System.out.println("Tours box has remained checked");
        }catch (NoSuchElementException e){

        }



    }


}
