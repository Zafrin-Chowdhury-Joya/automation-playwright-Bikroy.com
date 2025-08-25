// SignupTest.java
package com.automation.tests;

import com.automation.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test(priority=1)
    public void testSignup() {
        page.click("(//span[@class='title--1NHWk gtm-login-click'])[1]");
        page.click("//span[@class='email-text--FbASN']");
        page.click("//button[normalize-space()='Sign up']");

        page.fill("//input[@id='input_name']", "Zafrin Chowdhury");
        page.fill("//input[@id='input_email']", "zafrinchowdhury.047@gmail.com");
        page.fill("//input[@id='input_password']", "Zafrin12345&");
        page.fill("//input[@id='input_password-confirm']", "Zafrin12345&");

        page.click("//button[normalize-space()='Sign up']");

        // Wait for account title after sign up
        page.waitForSelector("(//span[@class='title--1NHWk gtm-myaccount-click'])[1]");
        Assert.assertTrue(
            page.isVisible("(//span[@class='title--1NHWk gtm-myaccount-click'])[1]")
        );
    }
}
