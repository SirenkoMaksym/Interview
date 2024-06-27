/*
 * created by max$
 */


package com.ebay.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MyListener implements WebDriverListener {
    Logger logger= LoggerFactory.getLogger(MyListener.class);

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);

        logger.info("After find element --> " + locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);
        logger.info(("Before find Elements -->" + locator));
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
        logger.info("After find elements -->" + locator);
        logger.info("List size is " + result.size());
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);

        logger.info("Something went wrong!!!");
        logger.info("***********************************************************");
        logger.info("Method --> " + method.getName());
        logger.info("***********************************************************");
        logger.info("Target exception " + e.getTargetException());
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        WebDriverListener.super.beforeGet(driver, url);

        logger.info("Before navigate to URL --> " + url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        WebDriverListener.super.afterGet(driver, url);
        logger.info("After navigate to URL --> " + url);
    }
}
