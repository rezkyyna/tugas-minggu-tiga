package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectList {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Open Browser");
        driver.get("https://demoqa.com/select-menu");
        System.out.println("Open URL");

        String titlePage = driver.findElement(By.className("main-header")).getText();
        System.out.println(titlePage);

        //select
        Select pilihWarna =new Select(driver.findElement(By.id("oldSelectMenu")));
        js.executeScript("window.scrollBy(0,300)");
        pilihWarna.selectByValue("4");
        pilihWarna.selectByVisibleText("Blue");
        pilihWarna.selectByIndex(8);
        System.out.println("pilihwarna");


        driver.quit();
    }
}
