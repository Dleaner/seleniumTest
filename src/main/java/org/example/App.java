package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class App
{

    public static void main(String[] args ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        WebElement input = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        input.click();
        

    }
}
