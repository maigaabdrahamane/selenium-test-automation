package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="user-name")
    private WebElement username;
    @FindBy(id="password")
    private  WebElement password;
    @FindBy(id="login-button")
    private WebElement login;

    WebDriver driver ;
    public LoginPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void LoginAsUser()
    {
        username.click();
        username.sendKeys("standard_user");


        password.click();
        password.sendKeys("secret_sauce");


        login.click();
    }

    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }
}
