package org.example.core;

import com.microsoft.playwright.Page;

public class PageInstance {
    private static PageInstance instance;
    private Page page;

    private PageInstance() {
    }

    public static PageInstance pageInstance() {
        if (instance == null) instance = new PageInstance();
        return instance;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return this.page;
    }
}
