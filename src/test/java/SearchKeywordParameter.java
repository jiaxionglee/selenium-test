import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.SerachResultPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by jiaxiong on 2019-02-17 14:20
 */
public class SearchKeywordParameter {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-–start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test(dataProvider = "getData")
    public void test(String keyword) {

        driver.get("https://testerhome.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePage homePage = new HomePage(driver);

        //String keyword = "selenium";
        SerachResultPage serachResultPage = homePage.gotoSearchResult(keyword);

        assertTopic(keyword, serachResultPage);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] objects = {{"selenium"},{"testng"}};
        return objects;
    }

    private void assertTopic(String value, SerachResultPage serachResultPage) {

        String actualTopic = "";
        for (WebElement topic : serachResultPage.getTopics()) {
            actualTopic = topic.getText().trim().toLowerCase();
            Assert.assertTrue(actualTopic.contains(value), "期待的标题不含含" + value + "实际标题是：" + actualTopic);
        }
    }
}
