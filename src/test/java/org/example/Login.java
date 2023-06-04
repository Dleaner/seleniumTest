package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static WebDriver driver;

    public void login() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        driver = new ChromeDriver();
        // Открытие страницы добавления пользователей
        driver.get("file:///C:/Users/egor2/Downloads/qa-test.html");
        // Вход в аккаунт
        WebElement emailInput = driver.findElement(By.id("loginEmail"));
        emailInput.sendKeys("test@protei.ru");

        WebElement passwordInput = driver.findElement(By.id("loginPassword"));
        passwordInput.sendKeys("test");

        WebElement authButton = driver.findElement(By.id("authButton"));
        authButton.click();

    }
}
