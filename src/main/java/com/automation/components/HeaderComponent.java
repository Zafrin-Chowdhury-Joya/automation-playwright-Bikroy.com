package com.automation.components;

import com.microsoft.playwright.Page;

public class HeaderComponent {
    private final Page page;

    public HeaderComponent(Page page) {
        this.page = page;
    }

    public void clickLogo() {
        page.click("css=header .logo");
    }
}