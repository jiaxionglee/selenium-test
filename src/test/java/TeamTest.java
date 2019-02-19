import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.TeamPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by jiaxiong on 2019-02-18 14:40
 */
public class TeamTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @Test
    public void test() throws InterruptedException {

        //打开主页
        driver.get("https://testerhome.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //去社团页面
        HomePage homePage = new HomePage(driver);
        TeamPage teamPage = homePage.gotoTeamPage();

        //点击社团第一条话题
        teamPage.gotoTeamDetail().clickTopic();

        //验证包含 "访问被拒绝"
        String expectResult = "访问被拒绝";
        Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains(expectResult),"期待不包含：" + expectResult);

    }

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }
}
