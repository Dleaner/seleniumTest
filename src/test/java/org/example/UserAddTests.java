package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class UserAddTests extends Login {
    @Test
    public void shouldAdded() {
        // Тестовые значения
        String testEmail = "test@example.com";
        String testName = "Mr Smith";
        String testGender = "Мужской";

        // Вход
        login();

        // Заполнение полей ввода
        // Email
        WebElement emailData = driver.findElement(By.id("dataEmail"));
        emailData.sendKeys(testEmail);
        // Password
        WebElement nameData = driver.findElement(By.id("dataName"));
        nameData.sendKeys(testName);
        // Gender
        WebElement genderData = driver.findElement(By.id("dataGender"));
        Select select = new Select(genderData);
        select.selectByVisibleText(testGender);

        // Выбор checkBox
        WebElement checkBox1 = driver.findElement(By.id("dataCheck11"));
        checkBox1.click();

        WebElement checkBox2 = driver.findElement(By.id("dataCheck12"));
        checkBox2.click();

        // Выбор radioButton
        WebElement radioButton1 = driver.findElement(By.id("dataSelect21"));
        radioButton1.click();

        // Нажатие на кнопку "Добавить"
        WebElement addButton = driver.findElement(By.id("dataSend"));
        addButton.click();

        // Проверка появления окна уведомления
        WebElement okButton = driver.findElement(By.xpath("//button[@class='uk-button uk-button-primary uk-modal-close']"));
        okButton.click();

        // Проверка, что пользователь появился в таблице
        List<WebElement> dataTable = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr/td"));

        Assertions.assertEquals(dataTable.get(0).getText(), testEmail);
        Assertions.assertEquals(dataTable.get(1).getText(), testName);
        Assertions.assertEquals(dataTable.get(2).getText(), testGender);
        Assertions.assertEquals(dataTable.get(3).getText(), "1.1, 1.2");
        Assertions.assertEquals(dataTable.get(4).getText(), "2.1");

        // Закрытие браузера
        driver.quit();
    }

    @Test
    public void shouldNotAdded() {
        // Вход
        login();

        // Нажатие на кнопку
        WebElement addButton = driver.findElement(By.id("dataSend"));
        addButton.click();

        // Проверка, есть ли элемент в таблице
        WebElement dataTable = driver.findElement(By.xpath("//table[@id='dataTable']/tbody"));
        String value = dataTable.getAttribute("childElementCount");
        Assertions.assertEquals(value, "0");

        // Закрытие браузера
        driver.quit();
    }
}
