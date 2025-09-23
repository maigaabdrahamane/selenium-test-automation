package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class ProductPage {
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> listPrix;
    @FindBy(id ="add-to-cart-sauce-labs-bike-light")
            private  WebElement button1;
    @FindBy(id ="add-to-cart-sauce-labs-bolt-t-shirt")
    private  WebElement button2;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
            private WebElement panier;



    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }

    public void filtreCroissant() {
        driver.findElement(cssSelector("option[value='lohi']")).click();
    }



    public boolean estAOrdreCroissant() {
        List<Double> list = new ArrayList<>();
        for (WebElement element : listPrix) {
            list.add(Double.valueOf((element.getText().replace("$", ""))));

        }

        System.out.print("La liste est : ");
        for (Double element :list) {
            System.out.print(element +" ");
        }

        int i ;

        for(i=0;i<list.size()-1;i++)
        {
            if(list.get(i)>list.get(i+1))
            {
                return false;
            }
        }

        return true;

    }
    public void add_to_cart1()
    {
        button1.click();
    }
    public void add_to_cart2()
    {
        button2.click();
    }

    public String afficher_panier()
    {
       return  panier.getText() ;
    }
}



