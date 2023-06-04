package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests extends Login {
    @Test
    public void shouldLogin() {
        // Вход
        login();

        // Проверка, открылась ли страница
        WebElement element = driver.findElement(By.xpath("//div[@id='authPage'][@style]"));
        Assertions.assertNotNull(element);

        // Закрытие браузера
        driver.quit();
    }

    @Test
    public void shouldNotLogin() {

        driver = new ChromeDriver();
        // Открытие страницы добавления пользователей
        driver.get("file:///C:/Users/egor2/Downloads/qa-test.html");
        // Вход в аккаунт
        WebElement emailInput = driver.findElement(By.id("loginEmail"));
        emailInput.sendKeys("wrong@protei.ru");

        WebElement passwordInput = driver.findElement(By.id("loginPassword"));
        passwordInput.sendKeys("wrong");

        WebElement authButton = driver.findElement(By.id("authButton"));
        authButton.click();
        // Проверка, открылась ли страница
        WebElement element = driver.findElement(By.xpath("//div[@id='inputsPage'][@style]"));
        Assertions.assertNotNull(element);

        // Закрытие браузера
        driver.quit();
    }
}
