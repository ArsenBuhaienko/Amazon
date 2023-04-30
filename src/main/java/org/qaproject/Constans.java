package org.qaproject;

public class Constans {
    public static final String URL = "https://www.amazon.com";
    public static final String CHROME_DRIVER_ARGUMENTS = "--remote-allow-origins=*";
    public static final String CHROME_DRIVER_PATH = "D:\\MyProjects\\MyProject\\src\\main\\resources\\chromeWebDriver\\chromedriver.exe";

    public static final String MENU_BUTTON_XPATH = "nav-hamburger-menu";

    public static final String COMPUTERS_CATEGORY_XPATH = "//div[contains(text(), 'Computers')]";
    public static final String SIZE_COMPUTERS_CATEGORY_XPATH = "//*[@id='hmenu-content']/ul[1]/li[8]";

    public static final String ELECTRONICS_CATEGORY_XPATH = "//div[contains(text(), 'Electronics')]";
    public static final String SIZE_ELECTRONICS_CATEGORY_XPATH = "//*[@id=\"hmenu-content\"]/ul[1]/li[7]";
}
