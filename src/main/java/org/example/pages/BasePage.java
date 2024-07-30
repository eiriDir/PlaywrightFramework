package org.example.pages;

import com.microsoft.playwright.Page;

import static org.example.core.PageInstance.pageInstance;

public abstract class BasePage {
    public BasePage() {
        this.page = pageInstance().getPage();
    }

    protected Page page;
}
