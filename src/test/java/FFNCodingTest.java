import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FFNCodingTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path to driver executable");
        driver = new ChromeDriver();
    }

    @Test
    public void firstQuestion() {
        driver.get("url of the page");

        //Getting all the dropDown elements
        WebElement firstDropDown = driver.findElement(By.xpath("//*[@id='firstDropDown']"));
        WebElement secondDropDown = driver.findElement(By.xpath("//*[@id='secondDropDown']"));
        WebElement thirdDropDown = driver.findElement(By.xpath("//*[@id='thirdDropDown']"));
        WebElement fourthDropDown = driver.findElement(By.xpath("//*[@id='fourthDropDown']"));

        //Storing all the drop downs in an ArrayList for iterating
        List<WebElement> dropDownList = new ArrayList<WebElement>();
        dropDownList.add(firstDropDown);
        dropDownList.add(secondDropDown);
        dropDownList.add(thirdDropDown);
        dropDownList.add(fourthDropDown);

        //Iterating over list of drop downs and selecting option using index
        for (int i = 0; i < dropDownList.size(); i++) {
            Select select = new Select(dropDownList.get(i));
            select.selectByIndex(i);
        }
    }

    @Test
    public void secondQuestion() {
        driver.get("url of the page");
        driver.findElement(By.xpath("//*[@id='clientDetailsTab']")).click();
        driver.findElement(By.xpath("//*[@id='takeAppOverPhone']")).click();

        WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName]"));
        WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName]"));

        //Asserting that the elements are not enabled.
        Assert.assertFalse(firstName.isEnabled());
        Assert.assertFalse(lastName.isEnabled());
    }

}
