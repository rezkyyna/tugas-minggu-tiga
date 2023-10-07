package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebTable {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Open Browser");
        driver.get("https://demoqa.com/webtables");
        System.out.println("Open URL");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Scraping : Mengambil data Text dari dalam web
        String title = driver.getTitle();
        System.out.println(title);
        String titlePage = driver.findElement(By.className("main-header")).getText();
        System.out.println(titlePage);

        //add data table
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Juara");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Koding");
        driver.findElement(By.id("userEmail")).sendKeys("admin@juaracoding.com");
        driver.findElement(By.id("age")).sendKeys("23");
        driver.findElement(By.id("salary")).sendKeys("6000");
        driver.findElement(By.id("department")).sendKeys("QA Enginerr");
        driver.findElement(By.id("submit")).click();

        //checkbox
        driver.get("https://demoqa.com/checkbox");
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label/span[3]")).click();

        //radio button
        driver.get("https://demoqa.com/radio-button");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label")).click();
        String txtImpressive = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span")).getText();
        System.out.println(txtImpressive);

        //compare text
        if(txtImpressive.equals("Impressive")){
            System.out.println("Passes");
        } else{
            System.out.println("Failed");
        }

        //closeweb
        driver.quit();
        System.out.println("Quit Browser");
    }
}
