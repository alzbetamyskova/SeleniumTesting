import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SelectTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:8888/zenaalebomuz.php";

    @Before
        public void setUp() {
            driver = new ChromeDriver();
        }

    @Test
        public void test() {
            driver.get(BASE_URL);
            driver.findElement(By.xpath("//input[@value='wurst']")).click();
            System.out.println(driver.findElement(By.xpath("//h1[@class='description text-center']")).getText());
            
            Assert.assertTrue(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
            Assert.assertFalse(driver.findElement(By.xpath("//input[@value='conchita']")).isSelected());

            System.out.println(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
            System.out.println(driver.findElement(By.xpath("//input[@value='conchita']")).isSelected());
        }

    @After
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.close();
        }

}        
