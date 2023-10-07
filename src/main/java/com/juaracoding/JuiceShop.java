package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JuiceShop {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://juice-shop.herokuapp.com/#/");
        driver.manage().window().maximize();

        //Login Website
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]/span[1]/span")).click();
        delay(2);
        driver.findElement(By.xpath("//*[@id=\"navbarAccount\"]")).click();
        driver.findElement(By.id("navbarLoginButton")).click();
        driver.findElement(By.id("email")).sendKeys("rkarunia88@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Kitabersama15.");
        driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[1]")).click();

        String txtLogin = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[2]/span[1]/span")).getText();
        System.out.println(txtLogin);
        if(txtLogin.equals("OWASP Juice Shop")){
            System.out.println("Passes");
        } else{
            System.out.println("Failed");
        }
        delay(2);


        //Add Cart (Apple Juice)
       driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[2]/button")).click();
       driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[4]/span[1]/mat-icon")).click();

       String txtCart = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-basket/mat-card/app-purchase-basket/h1")).getText();
       System.out.println(txtCart);
        if(txtCart.equals("Your Basket")){
            System.out.println("Passes");
        } else{
            System.out.println("Failed");
        }
        delay(2);


        //Checkout
        driver.findElement(By.xpath("//*[@id=\"checkoutButton\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"card\"]/app-address/mat-card/div/button")).click();
        //Form Adress
        driver.findElement(By.xpath("//*[@id=\"mat-input-3\"]")).sendKeys("Inggris");
        driver.findElement(By.xpath("//*[@id=\"mat-input-4\"]")).sendKeys("John");
        driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]")).sendKeys("100027357");
        driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")).sendKeys("451325");
        driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("London,Inggris");
        driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys("London");
        driver.findElement(By.xpath("//*[@id=\"mat-input-9\"]")).sendKeys("Inggris");
        delay(5);
        driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click();


        driver.quit();

    }

    static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}