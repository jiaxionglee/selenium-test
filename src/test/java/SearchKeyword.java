import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaxiong on 2019-02-17 14:20
 */
public class SearchKeyword extends BaseTest {

    @Test
    public void test() {

        driver.get(url);
        HomePage homePage = new HomePage(driver);
        String keyword = "selenium";
        SearchResultPage searchResultPage = homePage.gotoSearchResult(keyword);

        List<String> assertMsg = new ArrayList<String>();
        for (String topic : searchResultPage.getTopicTitle()) {
            if (!topic.contains(keyword)) {
                assertMsg.add("期待的标题不含含" + keyword + "实际标题是：" + topic);
            }
        }
        if (!assertMsg.isEmpty()) {
            Assert.assertTrue(false, assertMsg.toString());
        }
    }

    private void assertTopic(String value, SearchResultPage serachResultPage) {
        String actualTopic = "";
        for (WebElement topic : serachResultPage.getTopics()) {
            actualTopic = topic.getText().trim().toLowerCase();
            Assert.assertTrue(actualTopic.contains(value), "期待的标题不含含" + value + "实际标题是：" + actualTopic);
        }
    }
}
