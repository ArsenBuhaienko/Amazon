package org.qaproject;
// Импорт библиотек
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
        options.addArguments("--whitelisted-ips=\"\"");

        // Создание объекта WebDriver с настройками ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        // Открытие страницы
        driver.get("https://www.youtube.com/");

        // Закрытие браузера
        driver.quit();
    }

}