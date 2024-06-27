/*
 * created by max$
 */


package com.ebay.fw;

import com.ebay.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {
    String browser;
    WebDriver driver;
    DepartmentHelper department;
    ItemHelper item;

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);


    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        System.err.close();

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.get("https://www.ebay.de/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        department = new DepartmentHelper(driver);
        item = new ItemHelper(driver);

    }

    public DepartmentHelper getDepartment() {
        return department;
    }

    public ItemHelper getItem() {
        return item;
    }

    public void stop() {
        driver.quit();
    }
}
