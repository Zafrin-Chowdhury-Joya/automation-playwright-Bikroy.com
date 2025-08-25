// LoginTest.java
package com.automation.tests;

import com.automation.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {



    @Test(priority = 1)
    public void testLoginWithInvalidPassword() {
        // Open login popup
        page.click("(//span[@class='title--1NHWk gtm-login-click'])[1]");
        page.click("//span[@class='email-text--FbASN']");

        // Fill credentials (valid email, invalid password)
        page.fill("//input[@id='input_email']", "zafrinchowdhury.047@gmail.com");
        page.fill("//input[@id='input_password']", "WrongPassword123!");

        // Click Login
        page.click("//button[normalize-space()='Login']");

        // Wait for error message
        page.waitForSelector("//div[contains(@class,'error')]");

        // Assert error visible
        Assert.assertTrue(
            page.isVisible("//div[contains(@class,'error')]"),
            "Expected error message for invalid password"
        );

        // Clear fields
        page.fill("//input[@id='input_email']", "");
        page.fill("//input[@id='input_password']", "");
        page.navigate("https://bikroy.com/");
    }

    @Test(priority = 2)
    public void testLoginWithInvalidEmail() {
        // Open login popup
        page.click("(//span[@class='title--1NHWk gtm-login-click'])[1]");
        page.click("//span[@class='email-text--FbASN']");

        // Fill credentials (invalid email, valid password)
        page.fill("//input[@id='input_email']", "invalid.email@test.com");
        page.fill("//input[@id='input_password']", "Zafrin12345&");

        // Click Login
        page.click("//button[normalize-space()='Login']");

        // Wait for error message
        page.waitForSelector("//div[contains(@class,'error')]");

        // Assert error visible
        Assert.assertTrue(
            page.isVisible("//div[contains(@class,'error')]"),
            "Expected error message for invalid email"
        );

        // Clear fields
        page.fill("//input[@id='input_email']", "");
        page.fill("//input[@id='input_password']", "");
        page.navigate("https://bikroy.com/");
    }
    @Test(priority = 3)
    public void testLoginWithValidCredentials() {
        // Open login popup
        page.click("(//span[@class='title--1NHWk gtm-login-click'])[1]");
        page.click("//span[@class='email-text--FbASN']");

        // Fill credentials
        page.fill("//input[@id='input_email']", "zafrinchowdhury.047@gmail.com");
        page.fill("//input[@id='input_password']", "Zafrin12345&");

        // Click Login
        page.click("//button[normalize-space()='Login']");

        // Wait until account icon is visible
        page.waitForSelector("//a[@aria-label='Account']");

        // Assert login success
        Assert.assertTrue(
            page.isVisible("//a[@aria-label='Account']"),
            "Expected account link to be visible after login"
        );
        page.navigate("https://bikroy.com/");
    }
}
