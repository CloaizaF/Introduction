package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        //When we do not put this line, the Selenium Manager downloads the file for us
        //System.setProperty("webdriver.chrome.driver", "pathOfChromeDriverFile");
        //System.setProperty("webdriver.gecko.driver", "pathOfGeckoDriverFile");
        //WebDriver driver = new FirefoxDriver();
        //System.setProperty("webdriver.edge.driver", "pathOfGeckoDriverFile");
        //WebDriver driver = new EdgeDriver();

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();

    }
}