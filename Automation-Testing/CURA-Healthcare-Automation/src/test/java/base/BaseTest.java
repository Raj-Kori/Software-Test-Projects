package base;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class BaseTest {
 protected WebDriver driver;
 @BeforeMethod public void setUp(){ driver=new ChromeDriver(); driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); driver.manage().window().maximize(); driver.get("https://katalon-demo-cura.herokuapp.com/"); }
 @AfterMethod public void tearDown(){ if(driver!=null) driver.quit(); }
}