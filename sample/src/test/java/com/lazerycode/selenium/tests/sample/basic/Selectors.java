package com.lazerycode.selenium.tests.sample.basic;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.tests.TestProperties;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Selectors extends DriverBase {

    /*
     *  다양한 방법으로 element에 접근할 수 있다.
     */
    @Test
    public void test() throws Exception {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(TestProperties.test_url + "/tables");
       
        
        // 방법 1. css selector
        WebElement element = driver.findElement(By.cssSelector("#table1 > thead > tr > th.header > span"));
        System.out.println(element.getText());
        
        // 방법 2. xpath selector
        element = driver.findElement(By.xpath("//*[@id='table1']/thead/tr/th[1]/span"));
        System.out.println(element.getText());
        
        // 방법 3. chain
        element = driver.findElement(By.id("table1")).findElement(By.cssSelector("thead > tr > th.header > span"));
        System.out.println(element.getText());
        
        // Get list
        List<WebElement> list = driver.findElements(By.cssSelector("#table1 > tbody > tr"));
        for(WebElement e: list) {
        	System.out.println(e.getText());
        }
        
    }
}