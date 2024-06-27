/*
 * created by max$
 */


package com.ebay.tests;

import com.ebay.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
            Browser.FIREFOX.browserName()));

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        app.stop();
    }
}
