package org.qaproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AmazonPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public AmazonPage() {
        System.setProperty("webdriver.chrome.driver", Constans.CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments(Constans.CHROME_DRIVER_ARGUMENTS);
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, ofSeconds(10));
    }

    public void setUp() {
        driver.get(Constans.URL);
    }

    public void tearDown() {
        driver.quit();
    }

    public void clickMenuButton() {
        WebElement menuButton = wait.until(visibilityOfElementLocated(By.id(Constans.MENU_BUTTON_XPATH)));
        menuButton.click();
    }

    public int countComputersCategory() {
        return driver.findElements(By.xpath(Constans.COMPUTERS_CATEGORY_XPATH)).size();
    }

    public Dimension sizeComputersCategory() {
        WebElement computersCategory = wait.until(visibilityOfElementLocated(By.xpath(Constans.SIZE_COMPUTERS_CATEGORY_XPATH)));
        return computersCategory.getSize();
    }

    public int countElectronicsCategory() {
        return driver.findElements(By.xpath(Constans.ELECTRONICS_CATEGORY_XPATH)).size();
    }

    public Dimension sizeElectronicsCategory() {
        WebElement computersCategory = wait.until(visibilityOfElementLocated(By.xpath(Constans.SIZE_ELECTRONICS_CATEGORY_XPATH)));
        return computersCategory.getSize();
    }

}