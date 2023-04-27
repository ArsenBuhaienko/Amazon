// ЭТОТ КЛАСС ЯВЛЯЕТЬСЯ ЧАСТЬЮ ПРОЕКТА ДЛЯ ПОРТФОЛИО
package org.qaproject;
// Импорт библиотек
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class AmazonTests {
    private WebDriver driver;
    private ChromeOptions options;
    private static final String URL = "https://www.amazon.com";
    private static final String CHROME_DRIVER_PATH = "D:\\MyProjects\\MyProject\\src\\main\\resources\\chromeWebDriver\\chromedriver.exe";

    @BeforeTest
    public void setUp() {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        // Создание объекта ChromeOptions
        options = new ChromeOptions();
        // Задание аргумента
        options.addArguments("--remote-allow-origins=*");
        // Создание объекта WebDriver с настройками ChromeOptions
        driver = new ChromeDriver(options);
        // Открытие страницы
        driver.get(URL);
    }



    @Test
    public void existComputers(){
        // создание локатора типа xPath
        WebElement menuButton = driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']"));
        menuButton.click();

        // Явное ожидание перед поиском элементов на странице
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement computersCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[8]")));

        int size = driver.findElements(By.xpath("//div[contains(text(), 'Computers')]")).size();
        Assert.assertEquals(size, 1);

        Assert.assertEquals(computersCategory.getSize().getHeight(), 44);
        Assert.assertEquals(computersCategory.getSize().getWidth(), 348);
        Dimension size3 = computersCategory.getSize();
        // Вывести размер элемента в консоль
        System.out.println("Width: " + size3.getWidth() + " Height: " + size3.getHeight());
    }
   /* @Test
    public void existElectronics(){
        // создание локатора типа xPath
        driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
        int size = driver.findElements(By.xpath("//div[contains(text(), 'Electronics')]")).size();
        Assert.assertEquals(size, 1);
        // Закрытие браузера
        driver.quit();
    }*/

    @AfterTest
    public void tearDown() {
        // Закрытие браузера
        driver.quit();
    }
}