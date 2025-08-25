package com.automation.pages;

import com.automation.base.BasePage;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }

    public String getTitle() {
        return page.title();
    }
}