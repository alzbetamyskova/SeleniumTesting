import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;



public class ForAndIf {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:8888/clickmebaby.php";

    @Before
        public void setUp(){
            driver = new ChromeDriver();
        }


    @Test
        public void ForaIf(){
            driver.get(BASE_URL);
            Assert.assertEquals("První počet kliků.", "0", driver.findElement(By.id("clicks")).getText());
            Assert.assertEquals("klikov", driver.findElement(By.xpath("//p")).getText());
            
            for (int i = 1; i < 65 ; i++) {
                driver.findElement(By.xpath("//button")).click();

                if (i==1) {
                    Assert.assertEquals("klik", driver.findElement(By.xpath("//p")).getText());
                }

                if (i >= 2 && i <= 4) {
                    Assert.assertEquals("kliky", driver.findElement(By.xpath("//p")).getText());
                }

                if (i > 4) {
                    Assert.assertEquals("klikov", driver.findElement(By.xpath("//p")).getText());
                }

            }

        }

    @After
        public void tearDown(){
            driver.quit();
    }
}
