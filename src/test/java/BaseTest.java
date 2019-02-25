import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ReadFileUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiaxiong on 2019-02-25 09:42
 */
public class BaseTest {

    WebDriver driver;
    String url = "";

    @BeforeMethod
    public void setUp() throws IOException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        url = ReadFileUtil.readYamlFile(ReadFileUtil.getPath("/config.yaml"), "url");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
