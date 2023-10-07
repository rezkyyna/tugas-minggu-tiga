package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Open Browser");
        driver.get("https://www.google.com/");
        System.out.println("Open URL");

        // locator search input
        driver.findElement(By.name("q")).sendKeys("Wikipedia");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        // Cara klik tombol, keys.ESC, Locatorname "btnK" panggil method klik


        // Delay
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Quit Browser");
    }
}