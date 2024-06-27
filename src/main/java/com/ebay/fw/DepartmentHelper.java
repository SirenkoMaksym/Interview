/*
 * created by max$
 */


package com.ebay.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepartmentHelper extends BaseHelper {
    public DepartmentHelper(WebDriver driver) {
        super(driver);
    }

    public void selectDepartment(String department) {
        click(By.xpath("//ul[@class='vl-flyout-nav__container']/li[" + department + "]"));
    }
}
