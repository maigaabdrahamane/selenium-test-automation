import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.*;

public class Form {
    @Test
    public  void test001_setup()
    {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        driver.manage().window().maximize();

// username
        WebElement username = driver.findElement(cssSelector("input[name='username']"));
        username.click();
        username.sendKeys("Big_man");
// password
        WebElement password = driver.findElement(cssSelector("input[name='password']"));
        password.click();
        password.sendKeys("Ramata");
// textarea
        WebElement textarea = driver.findElement(cssSelector("textarea[name='comments']"));
        textarea.clear();
        textarea.sendKeys("benanou je n'ai pleuré ");
// filename
        WebElement filename = driver.findElement(cssSelector("input[name='filename']"));
        filename.sendKeys("C:\\Users\\abmaiga\\IdeaProjects\\Selenium_project\\target\\images\\Organisation.png");
// checkbox
        WebElement checkbox1= driver.findElement(cssSelector("input[value='cb1']"));
       checkbox1.click();

        WebElement checkbox3= driver.findElement(cssSelector("input[value='cb3']"));
        checkbox3.click();

// radio

        WebElement radio1= driver.findElement(cssSelector("input[value='rd1']"));
        radio1.click();

// selectvalues

        WebElement select1= driver.findElement(cssSelector("option[value='ms1']"));
        select1.click();

        WebElement select4= driver.findElement(cssSelector("option[value='ms4']"));
        select4.click();
// dropdown
        WebElement drop1= driver.findElement(cssSelector("option[value='dd2']"));
        drop1.click();

        WebElement drop3= driver.findElement(cssSelector("option[value='dd3']"));
        drop3.click();

// submit

// Verification
        WebElement checkuser =  driver.findElement(By.id("_username"));
        //System.out.print(checkuser.getText());
        assertEquals(checkuser.getText(),"Udemy");


    }
}
