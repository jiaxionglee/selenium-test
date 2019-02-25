import org.testng.annotations.Test;
import page.HomePage;
import utils.ReadFileUtil;

import java.io.IOException;

/**
 * Created by jiaxiong on 2019-02-17 15:10
 */
public class ClickBanner extends BaseTest {
    @Test
    public void test() throws IOException, InterruptedException {
        driver.get(url);
        String expectTitle = ReadFileUtil.readYamlFile(ReadFileUtil.getPath("/clickBanner.yaml"), "expectTitle");
        new HomePage(driver).clickBannerAndReturnPage(5).waitTitleContains(5, expectTitle);
    }
}
