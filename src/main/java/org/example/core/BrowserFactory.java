package org.example.core;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserFactory {
    private static final Logger log = LoggerFactory.getLogger(BrowserFactory.class);

    public static Browser getBrowser(String browser) {
        switch (browser) {
            case "chrome":
                return configChrome();
            case "firefox":
                return configFirefox();
            case "webkit":
                return configWebkit();
            default:
                log.debug("Unknown browser. Сhrome is selected by default.");
                return configChrome();
        }
    }

    private static Browser configChrome() {
        return Playwright.create().chromium().launch(options());
    }

    private static Browser configFirefox() {
        return Playwright.create().firefox().launch(options());
    }

    //todo what is webkit
    private static Browser configWebkit() {
        return Playwright.create().webkit().launch(options());
    }

    public static LaunchOptions options() {
        return new LaunchOptions()
                .setHeadless(false)
                .setSlowMo(50);
    }
}
