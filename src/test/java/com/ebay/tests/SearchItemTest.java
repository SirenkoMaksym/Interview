/*
 * created by max$
 */


package com.ebay.tests;

import org.testng.annotations.Test;

public class SearchItemTest extends TestBase{

    @Test
    public void searchItemPositiveTest(){

        app.getDepartment().selectDepartment("2");
       /* app.getDepartment().selectSection("");
        app.getDepartment().selectBrand("");*/

    }


}
