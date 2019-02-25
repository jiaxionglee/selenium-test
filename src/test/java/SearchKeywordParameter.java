import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;

/**
 * Created by jiaxiong on 2019-02-17 14:20
 */
public class SearchKeywordParameter extends BaseTest {

    @Test(dataProvider = "getData")
    public void test(String keyword) {
        driver.get(url);
        HomePage homePage = new HomePage(driver);
        SearchResultPage serachResultPage = homePage.gotoSearchResult(keyword);
        assertTopic(keyword, serachResultPage);
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] objects = {{"selenium"}, {"testng"}};
        return objects;
    }

    private void assertTopic(String value, SearchResultPage serachResultPage) {
        String actualTopic = "";
        for (WebElement topic : serachResultPage.getTopics()) {
            actualTopic = topic.getText().trim().toLowerCase();
            Assert.assertTrue(actualTopic.contains(value), "期待的标题不含含" + value + "实际标题是：" + actualTopic);
        }
    }
}
