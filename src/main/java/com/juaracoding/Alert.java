package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Alert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Open Browser");
        driver.get("https://demoqa.com/alerts");
        System.out.println("Open URL");
        driver.manage().window().maximize();

        String titlePage = driver.findElement(By.className("main-header")).getText();
        System.out.println(titlePage);
        driver.findElement(By.id("alertButton")).click();
        delay(5);
        driver.switchTo().alert().accept();
        driver.findElement(By.id("timerAlertButton")).click();
        delay(5);
        driver.switchTo().alert().accept();
        js.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("JuaraCoding");
        driver.switchTo().alert().accept();
        System.out.println("alertsendkeys");


        delay(3);
        driver.quit();
        System.out.println("Quit Browser");

    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
