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
    public void test() {
        driver.get("https://testerhome.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePage homePage = new HomePage(driver);
        TeamPage teamPage = homePage.gotoTeamPage();

        LoginPage loginPage = teamPage.gotoTeamDetail().clickTopic();
        String expectResult = "访问被拒绝";

        System.out.println(loginPage.getText());

        Assert.assertTrue(loginPage.getText().contains(expectResult), "期待包含：" + expectResult + "实际结果：" + loginPage.getText());


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
