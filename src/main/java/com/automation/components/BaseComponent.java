package com.automation.components;

import com.microsoft.playwright.Page;
import java.util.logging.Logger;

public abstract class BaseComponent {
    protected final Page page;
    protected static final Logger LOGGER = Logger.getLogger(BaseComponent.class.getName());

    public BaseComponent(Page page) {
        this.page = page;
    }

    protected void navigateTo(String url) {
        LOGGER.info("Navigating to: " + url);
        page.navigate(url);
        slowDown(2000); // 2 seconds wait after navigation
    }

    protected void fillInput(String selector, String value) {
        LOGGER.info("Filling input: " + selector);
        slowDown(1000); // 1 second wait before filling
        page.fill(selector, value);
        slowDown(1000); // 1 second wait after filling
    }

    protected void clickButton(String selector) {
        LOGGER.info("Clicking button: " + selector);
        slowDown(1000); // 1 second wait before clicking
        page.click(selector);
        slowDown(1000); // 1 second wait after clicking
    }

    protected boolean isElementVisible(String selector) {
        return page.isVisible(selector);
    }

    // Method to introduce deliberate delays
    protected void slowDown(long milliseconds) {
        try {
            LOGGER.info("Waiting for " + milliseconds + " milliseconds");
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            LOGGER.warning("Wait interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
