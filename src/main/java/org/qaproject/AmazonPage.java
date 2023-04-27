package org.qaproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private ChromeOptions options;
    private static final String URL = "https://www.amazon.com";
    private static final String CHROME_DRIVER_PATH = "D:\\MyProjects\\MyProject\\src\\main\\resources\\chromeWebDriver\\chromedriver.exe";

    public AmazonPage() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setUp() {
        driver.get(URL);
    }

    public void tearDown() {
        driver.quit();
    }

    public void clickMenuButton() {
        WebElement menuButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-hamburger-menu")));
        menuButton.click();
    }

    public void findComputersCategory() {
        WebElement computersCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='hmenu-content']/ul[1]/li[8]")));
    }

    public int countComputersCategory() {
        return driver.findElements(By.xpath("//div[contains(text(), 'Computers')]")).size();
    }

    public Dimension sizeComputersCategory() {
        WebElement computersCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='hmenu-content']/ul[1]/li[8]")));
        Dimension computersCategorySize = computersCategory.getSize();
        return computersCategorySize;
    }
}