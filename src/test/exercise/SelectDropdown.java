import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.lang.Thread;

public class SelectDropdown {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:8888/vybersi.php";

    @Before
        public void setUp() {
            driver = new ChromeDriver();
        }

    @Test
        public void selectFromDropdown () {
            driver.get(BASE_URL);

            new Select(driver.findElement(By.xpath("//select"))).selectByValue("02");
            new Select(driver.findElement(By.xpath("//select"))).selectByIndex(1);
            new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText("Pikachu");

            System.out.println(driver.findElement(By.xpath("//div/h3")).getText());

            Assert.assertTrue(driver.findElement(By.xpath("//div/h3")).getText().contains("Pikachu"));
            Assert.assertFalse(driver.findElement(By.xpath("//div/h3")).getText().contains("Fael"));
        }

    @After
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }

}
