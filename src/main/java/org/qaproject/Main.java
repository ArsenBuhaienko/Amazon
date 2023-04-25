// ЭТОТ КЛАСС ЯВЛЯЕТЬСЯ ЧАСТЬЮ ПРОЕКТА ДЛЯ ПОРТФОЛИО
package org.qaproject;
// Импорт библиотек
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Main {

    WebDriver driver;
    ChromeOptions options;
    String url = "https://www.amazon.com";
    String chromeParameters = "--remote-allow-origins=*";
    String pathToChromeDriver = "D:\\MyProjects\\MyProject\\src\\main\\resources\\chromeWebDriver\\chromedriver.exe";

    @Test
    public void existComputers(){
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver",pathToChromeDriver);
        // Создание объекта ChromeOptions
        options = new ChromeOptions();
        // Задание аргумента
        options.addArguments(chromeParameters);
        // Создание объекта WebDriver с настройками ChromeOptions
         driver = new ChromeDriver(options);
        // Открытие страницы
        driver.get(url);
        // создание локатора типа xPath
        driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
        int size = driver.findElements(By.xpath("//div[contains(text(), 'Computers')]")).size();
        Assert.assertEquals(size, 1);
        // Закрытие браузера
        driver.quit();
    }
    @Test
    public void existElectronics(){
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver",pathToChromeDriver);
        // Создание объекта ChromeOptions
        options = new ChromeOptions();
        // Задание аргумента
        options.addArguments(chromeParameters);
        // Создание объекта WebDriver с настройками ChromeOptions
        driver = new ChromeDriver(options);
        // Открытие страницы
        driver.get(url);
        // создание локатора типа xPath
        driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
        int size = driver.findElements(By.xpath("//div[contains(text(), 'Electronics')]")).size();
        Assert.assertEquals(size, 1);
        // Закрытие браузера
        driver.quit();
    }

}