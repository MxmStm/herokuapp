import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HerokuAppTest {

    @Test
    public void addRemoveElements(){
        By addManuallyButton = By.xpath("//button[text()='Add Element']");
        By deleteButton = By.className("added-manually");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(addManuallyButton).click();
        driver.findElement(addManuallyButton).click();
        driver.findElements(deleteButton).get(0).click();
        int numberOfDeleteButtons = driver.findElements(deleteButton).size();
        assertEquals(numberOfDeleteButtons,1,"Number of elements is not correct");

        driver.quit();
    }
}
