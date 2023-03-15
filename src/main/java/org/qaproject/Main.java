// ЭТОТ КЛАСС ЯВЛЯЕТЬСЯ ЧАСТЬЮ ПРОЕКТА ДЛЯ ПОРТФОЛИО
package org.qaproject;
// Импорт библиотек

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Keys;

public class Main {
    public static void main(String[] args) {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver","D:\\MyProjects\\MyProject\\src\\main\\resources\\chromeWebDriver\\chromedriver.exe");

        // Создание объекта ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // Задание аргумента
        options.addArguments("--remote-allow-origins=*");

        // Создание объекта WebDriver с настройками ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        // Открытие страницы
          driver.get("https://aliexpress.ru/");

        // создание локатора типа xPath
        WebElement inputField = driver.findElement(By.id("searchInput"));
        inputField.clear();
        inputField.sendKeys("Кросовки");
        inputField.sendKeys(Keys.ENTER);


        WebElement goods = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div[2]/div/div/div/div[1]/div/a/div/div[3]"));
        goods.click();


        WebElement buy = driver.findElement(By.xpath("//*[@id=\"buyNowButton\"]/div/div[1]/div[2]/div/button"));
        buy.click();
        // Закрытие браузера
       // driver.quit();
    }

}