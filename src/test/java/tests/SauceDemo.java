package tests;

import utils.LoginPage;
import utils.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SauceDemo {

    private static FirefoxDriver driver;
    private static LoginPage loginPage;
    private static ProductPage productPage;

    @BeforeAll
public static void setup() {
    // Installer le driver Firefox
    WebDriverManager.firefoxdriver().setup();

    // Options Firefox : headless et profil temporaire
    FirefoxOptions options = new FirefoxOptions();
    options.addArguments("--headless"); // mode headless
    options.setProfile(new FirefoxProfile()); // profil temporaire

    // Initialisation du driver
    driver = new FirefoxDriver(options);
    driver.get("https://saucedemo.com/");
    driver.manage().window().maximize();

    // Initialisation des pages
    loginPage = new LoginPage(driver);
    productPage = new ProductPage(driver);
}

    @AfterAll
    public static void teardown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void testLogin() {
        loginPage.loginAsUser();
        assertEquals("https://www.saucedemo.com/inventory.html", productPage.getCurrentUrl());
    }

    @Test
    public void testFiltrer() {
        productPage.filtreCroissant();
    }

    @Test
    public void testListePrixOrdre() {
        productPage.filtreCroissant();
        assertTrue(productPage.estAOrdreCroissant());
    }

    @Test
    public void testAjouterAuPanier() {
        productPage.addToCart1();
        assertEquals("1", productPage.afficherPanier());

        productPage.addToCart2();
        assertEquals("2", productPage.afficherPanier());
    }
}
