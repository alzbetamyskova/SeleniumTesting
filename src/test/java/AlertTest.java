import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost:8888/redalert.php";

    @Before
        public void setUp() {
            driver = new ChromeDriver();
        }

    @Test
        public void test() {
            driver.get(BASE_URL);

            driver.findElement(By.id("alert1")).click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            assertThat(driver.findElement(By.className("result")).getText(), is("Kirov Reporting"));

            driver.findElement(By.id("alert2")).click();
            Alert alert2 = driver.switchTo().alert();
            System.out.println(alert2.getText());
            alert2.dismiss();
            Assert.assertEquals("Negative", driver.findElement(By.className("result")).getText());

            driver.findElement(By.id("alert3")).click();
            Alert alert3 = driver.switchTo().alert();
            alert3.sendKeys("Lii");
            alert3.accept();
            Assert.assertTrue(driver.findElement(By.className("result")).getText().contains("Lii"));
            System.out.println(driver.findElement(By.className("result")).getText());
        }

    @After
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.close();
    }

}
