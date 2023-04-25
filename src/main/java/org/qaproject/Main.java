// ЭТОТ КЛАСС ЯВЛЯЕТЬСЯ ЧАСТЬЮ ПРОЕКТА ДЛЯ ПОРТФОЛИО
package org.qaproject;
// Импорт библиотек
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
            driver.get("https://www.amazon.com");

            // создание локатора типа xPath
            driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
            int size = driver.findElements(By.xpath("//div[contains(text(), 'Electronics')]")).size();
            //assert.assertEquals(size, 1);

            // Закрытие браузера
            // driver.quit();


    }

}