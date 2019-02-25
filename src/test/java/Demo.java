import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiaxiong on 2019-02-15 19:52
 */
public class Demo {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        //设置系统变量
        String path = "/selenium-test/src/main/drivers/chromedrvier";
        //System.setProperty("webdriver.chrome.driver ", System.getProperty("user.dir")+path);
        //System.setProperty("webdriver.chrome.driver ", new File(path).getAbsolutePath());

        //--headless模式
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        //WebDriver driver=new ChromeDriver(options);

        driver.get("https://testerhome.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //By login=By.linkText("登录");
        //WebElement loginElement = driver.findElement(login);
        //loginElement.click();

        //图片
        //By logoImg=By.cssSelector(".content img");
        //driver.findElement(logoImg).click();

        //搜索框css
        By search = By.cssSelector(".form-group input");
        //xpath
        By searchXPath = By.xpath("//*[@class='form-group']//input");

        driver.findElement(searchXPath).sendKeys("appium");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

}
