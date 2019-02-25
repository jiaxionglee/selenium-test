import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.TeamPage;

/**
 * Created by jiaxiong on 2019-02-18 14:40
 */
public class TeamTest extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        //打开主页
        driver.get(url);
        //去社团页面
        HomePage homePage = new HomePage(driver);
        TeamPage teamPage = homePage.gotoTeamPage();
        //点击社团第一条话题
        teamPage.gotoTeamDetail().clickTopic();
        //验证包含 "访问被拒绝"
        String expectResult = "访问被拒绝";
        Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains(expectResult), "期待不包含：" + expectResult);
    }
}
