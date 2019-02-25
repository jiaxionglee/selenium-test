import org.testng.annotations.Test;
import page.CommunitPage;
import page.HomePage;
import utils.ReadFileUtil;

import java.io.IOException;

/**
 * Created by jiaxiong on 2019-02-24 14:13
 */
public class NotSignInTest extends BaseTest {

    @Test
    public void testNotSignIn() throws IOException {

        String menu = ReadFileUtil.readYamlFile(ReadFileUtil.getPath("/notSignIn.yaml"), "menu");
        String communityName = ReadFileUtil.readYamlFile(ReadFileUtil.getPath("/notSignIn.yaml"), "communityName");

        driver.get(url);
        HomePage homePage = new HomePage(driver);
        homePage.clickBar(menu);
        CommunitPage communitPage = new CommunitPage(driver);
        communitPage.clickCommunityByText(communityName);
        communitPage.clickTopic();
    }
}
