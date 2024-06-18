import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:8888/tabulka.php";

    @Before
        public void setUp() {
            driver = new ChromeDriver();
        }

    @Test
        public void test() {
            driver.get(BASE_URL);
            List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
            for (WebElement row : rows) {
                
                System.out.println(row.getText());
                System.out.println(row.findElement(By.xpath("./td[3]")).getText());
            }
        }

    @After
        public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
