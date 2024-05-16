import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WalkthroughTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:8888/tabulka.php";
    
    @Before
        public void setUp() {
            driver = new ChromeDriver();

        }

    @Test
        public void Walkthrugh() {
            driver.get(BASE_URL);
            int rows = Integer.parseInt(driver.findElement(By.xpath("//tr[last()]/td[1]")).getText());
            for (int i = 1; i < rows+1; i++) {
                // System.out.println(driver.findElement(By.xpath("//tr[" + i +"]")).getText());
                Assert.assertFalse(driver.findElement(By.xpath("//tr[" + i +"]/td[3]")).getText().isEmpty());
            }
            
        }

    @After
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.close();

        }
}

