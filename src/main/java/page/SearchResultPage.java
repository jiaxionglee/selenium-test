package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaxiong on 2019-02-17 14:35
 */
public class SearchResultPage extends NavBarPage {

    @FindBy(css = ".topic a")
    private List<WebElement> topics;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getTopics() {
        return topics;
    }

    public List<String> getTopicTitle() {
        List<String> list = new ArrayList<String>();
        for (WebElement topic : topics) {
            list.add(topic.getText().trim().toLowerCase());
        }
        return list;
    }

}
