package SauceDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utils.LoginPage;
import utils.ProductPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.cssSelector;

public class SauceDemo {
    static  EdgeDriver driver;
    @BeforeAll
    public static void setup()
    {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\abmaiga\\IdeaProjects\\Selenium_project\\src\\test\\java\\msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);
        driver.get("https://saucedemo.com/");
        driver.manage().window().maximize();
    }
    @Test
    public  void test001_login()
    {

        LoginPage pageLogin = new LoginPage(driver);
        ProductPage pageProduct =new ProductPage(driver);
        pageLogin.LoginAsUser();

        String currentUrl = pageProduct.getCurrentUrl();
        System.out.print("Hi :" +  currentUrl);
        assertEquals("https://www.saucedemo.com/inventory.html",currentUrl);

    }

    @Test
    public  void test002_filtrer()
    {

        ProductPage pageProduct =new ProductPage(driver);
        pageProduct.filtreCroissant();

    }

    @Test
    public void test003_list_prix_a_lordre()
    {
        ProductPage pageProduct =new ProductPage(driver);
        pageProduct.filtreCroissant();
        assertTrue(pageProduct.estAOrdreCroissant());
    }
    @Test
    public void test004_ajouter_au_panier()
    {
        ProductPage pageProduct =new ProductPage(driver);
        pageProduct.add_to_cart1();
        assertEquals("1",pageProduct.afficher_panier());
        pageProduct.add_to_cart2();
        assertEquals("2",pageProduct.afficher_panier());

    }
}
