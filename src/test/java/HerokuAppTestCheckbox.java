import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HerokuAppTestCheckbox {

    @Test
    public void checkBoxValidation(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        assertEquals(checkBoxes.get(0).isSelected(),false,"First checkbox is selected");

        checkBoxes.get(0).click();
        assertEquals(checkBoxes.get(0).isSelected(),true,"First checkbox is not selected");

        assertEquals(checkBoxes.get(1).isSelected(),true,"Second checkbox is not selected");

        checkBoxes.get(1).click();
        assertEquals(checkBoxes.get(1).isSelected(),false,"Second checkbox is selected");

        driver.quit();
    }
}

