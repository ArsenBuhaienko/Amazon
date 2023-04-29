package org.qaproject;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SideBarMenu {
    private AmazonPage amazonPage;

    @BeforeTest
    public void setUp() {
        amazonPage = new AmazonPage();
        amazonPage.setUp();
    }

    @Test
    public void Computers() {
        amazonPage.clickMenuButton();
        amazonPage.findComputersCategory();
        amazonPage.countComputersCategory();
        amazonPage.sizeComputersCategory();

        int count = amazonPage.countComputersCategory();
        Assert.assertEquals(count, 1);

        Dimension size = amazonPage.sizeComputersCategory();
        Assert.assertEquals(size.getHeight(), 44);
        Assert.assertEquals(size.getWidth(), 348);
    }

    @Test
    public void Electronics() {
        //amazonPage.clickMenuButton();
        amazonPage.findCElectronicsCategory();
        amazonPage.countElectronicsCategory();
        amazonPage.sizeElectronicsCategory();

        int count = amazonPage.countElectronicsCategory();
        Assert.assertEquals(count, 1);

        Dimension size = amazonPage.sizeElectronicsCategory();
        Assert.assertEquals(size.getHeight(), 44);
        Assert.assertEquals(size.getWidth(), 348);
    }

    @AfterTest
    public void tearDown() {
        amazonPage.tearDown();
    }
}