package org.qaproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class AmazonPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private ChromeOptions options;
    private static final String URL = "https://www.amazon.com";
    private static final String CHROME_DRIVER_ARGUMENTS = "--remote-allow-origins=*";
    private static final String CHROME_DRIVER_PATH = "D:\\MyProjects\\MyProject\\src\\main\\resources\\chromeWebDriver\\chromedriver.exe";

    private static final String menuButtonXPath = "nav-hamburger-menu";
    private static final String computersCategoryXPath = "//div[contains(text(), 'Computers')]";
    private static final String sizeComputersCategoryXPath = "//*[@id='hmenu-content']/ul[1]/li[8]";

    private static final String electronicsCategoryXPath = "//div[contains(text(), 'Electronics')]";
    private static final String sizeElectronicsCategoryXPath = "//*[@id=\"hmenu-content\"]/ul[1]/li[7]";

    public AmazonPage() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        options = new ChromeOptions();
        options.addArguments(CHROME_DRIVER_ARGUMENTS);
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, ofSeconds(10));
    }

    public void setUp() {
        driver.get(URL);
    }

    public void tearDown() {
        driver.quit();
    }

    public void clickMenuButton() {
        WebElement menuButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(menuButtonXPath)));
        menuButton.click();
    }

    public void findComputersCategory() {
        WebElement computersCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(computersCategoryXPath)));
    }

    public int countComputersCategory() {
        return driver.findElements(By.xpath(computersCategoryXPath)).size();
    }

    public Dimension sizeComputersCategory() {
        WebElement computersCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sizeComputersCategoryXPath)));
        return computersCategory.getSize();
    }

    public void findCElectronicsCategory() {
        WebElement computersCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(electronicsCategoryXPath)));
    }

    public int countElectronicsCategory() {
        return driver.findElements(By.xpath(electronicsCategoryXPath)).size();
    }

    public Dimension sizeElectronicsCategory() {
        WebElement computersCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sizeElectronicsCategoryXPath)));
        Dimension computersCategorySize = computersCategory.getSize();
        return computersCategorySize;
    }

}