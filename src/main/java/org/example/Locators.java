package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Locators {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulacademy");
        driver.findElement(By.className("submit")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("milo@lol.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("rahul@shetty.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".reset-pwd-btn")));

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p ")).getText());

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputUsername")));

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

        try {
            driver.findElement(By.id("chkboxOne")).click();
        } catch (ElementClickInterceptedException e) {
            WebElement checkbox = driver.findElement(By.id("chkboxOne"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        }

        try {
            driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        } catch (ElementClickInterceptedException e) {
            WebElement signInButton = driver.findElement(By.xpath("//button[contains(@class,'submit')]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInButton);
        }

        driver.close();
    }
}
