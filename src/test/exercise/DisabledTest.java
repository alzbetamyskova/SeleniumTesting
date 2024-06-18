import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DisabledTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:8888/nemenne.php";

    @Before
        public void setUp() {
            driver = new ChromeDriver();
        }

    @Test
        public void test() {
            driver.get(BASE_URL);
            System.out.println(driver.findElement(By.xpath("//input[@value='Eva Mazikova']")).isEnabled());
            Assert.assertFalse(driver.findElement(By.id("sel1")).isEnabled());
            Assert.assertTrue(driver.findElement(By.id("sel2")).isEnabled());
            
            System.out.println(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[1]")).isEnabled());
            System.out.println(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[2]")).isEnabled());
            System.out.println(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[3]")).isEnabled());

            Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[1]")).isEnabled());
            Assert.assertTrue(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[3]")).isEnabled());

            System.out.println(driver.findElement(By.xpath("//button[contains(@class, 'btn-danger')]")).isEnabled());
            Assert.assertFalse(driver.findElement(By.xpath("//button[contains(@class, 'btn-danger')]")).isEnabled());
        }

    
     @After
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.close();
        }   
}
