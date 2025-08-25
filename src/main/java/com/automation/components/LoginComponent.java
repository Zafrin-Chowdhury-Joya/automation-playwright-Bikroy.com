package com.automation.components;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import java.util.List;
import java.util.Arrays;

public class LoginComponent extends BaseComponent {
    // Selectors
    private static final String USERNAME_SELECTOR = "#user-name";
    private static final String PASSWORD_SELECTOR = "#password";
    private static final String LOGIN_BUTTON_SELECTOR = "#login-button";
    private static final String ERROR_MESSAGE_SELECTOR = ".error-message-container";

    // Valid usernames
    private static final List<String> VALID_USERNAMES = Arrays.asList(
        "standard_user",
        "locked_out_user", 
        "problem_user", 
        "performance_glitch_user", 
        "error_user", 
        "visual_user"
    );
    private static final String DEFAULT_PASSWORD = "secret_sauce";

    public LoginComponent(Page page) {
        super(page);
    }

    public void navigateToLoginPage() {
        LOGGER.info("Preparing to navigate to Sauce Demo login page");
        navigateTo("https://www.saucedemo.com/");
        
        // Additional wait and verification
        slowDown(2000);
        LOGGER.info("Verifying login page is loaded");
        if (!isElementVisible(USERNAME_SELECTOR)) {
            LOGGER.warning("Login page may not have loaded correctly");
        }
    }

    public boolean login() {
        return login(VALID_USERNAMES.get(0), DEFAULT_PASSWORD);
    }

    public boolean login(String username, String password) {
        try {
            LOGGER.info("Starting login process for username: " + username);
            
            // Wait before interacting with username field
            slowDown(1500);
            LOGGER.info("Focusing on username field");
            page.focus(USERNAME_SELECTOR);
            
            // Fill username
            fillInput(USERNAME_SELECTOR, username);
            LOGGER.info("Username entered: " + username);
            
            // Wait before password field
            slowDown(1500);
            LOGGER.info("Focusing on password field");
            page.focus(PASSWORD_SELECTOR);
            
            // Fill password
            fillInput(PASSWORD_SELECTOR, password);
            LOGGER.info("Password entered");
            
            // Wait before login button
            slowDown(1500);
            LOGGER.info("Preparing to click login button");
            
            // Click login button
            clickButton(LOGIN_BUTTON_SELECTOR);
            LOGGER.info("Login button clicked");
            
            // Extended wait for page transition
            slowDown(3000);
            
            // Wait for page load
            page.waitForLoadState(LoadState.NETWORKIDLE);
            
            // Check login success
            boolean loginSuccess = isLoginSuccessful();
            
            if (loginSuccess) {
                LOGGER.info("Login successful for username: " + username);
            } else {
                LOGGER.warning("Login failed for username: " + username);
                
                // Log error message if available
                if (isElementVisible(ERROR_MESSAGE_SELECTOR)) {
                    String errorMessage = page.textContent(ERROR_MESSAGE_SELECTOR);
                    LOGGER.warning("Error message: " + errorMessage);
                }
            }
            
            return loginSuccess;
            
        } catch (Exception e) {
            LOGGER.severe("Exception during login: " + e.getMessage());
            return false;
        }
    }

    public boolean isLoginSuccessful() {
        // Extended check with more logging
        boolean urlCheck = page.url().contains("/inventory.html");
        boolean containerCheck = isElementVisible("#inventory-container");
        
        LOGGER.info("Login success check - URL contains /inventory.html: " + urlCheck);
        LOGGER.info("Login success check - Inventory container visible: " + containerCheck);
        
        return urlCheck || containerCheck;
    }

    public String getErrorMessage() {
        return isElementVisible(ERROR_MESSAGE_SELECTOR) ? 
               page.textContent(ERROR_MESSAGE_SELECTOR) : 
               "No error message found";
    }
}
