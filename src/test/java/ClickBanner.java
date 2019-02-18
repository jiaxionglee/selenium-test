import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.EventPage;
import page.HomePage;

import java.util.concurrent.TimeUnit;

/**
 * Created by jiaxiong on 2019-02-17 15:10
 */
public class ClickBanner {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-–start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://testerhome.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePage homePage = new HomePage(driver);
        String handle1 = driver.getWindowHandle();
        Reporter.log("第一个窗口" + handle1, true);
        homePage.clickBanner();

        //显示等待·
        //WebDriverWait wait = new WebDriverWait(driver,2);
        //wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //切换窗口
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equalsIgnoreCase(handle1)) {
                driver.switchTo().window(handle);
                Reporter.log("第二个窗口" + handle, true);
            }
        }

        String expectTitle = "大会";
        String actualTitle = new EventPage(driver).getPageTitle();
        //wait.until(ExpectedConditions.titleContains(expectTitle));

        Assert.assertTrue(actualTitle.contains(expectTitle), "期待网页包含标题" + expectTitle + "实际标题是" + actualTitle);

    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}
