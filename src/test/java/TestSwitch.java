import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import page.HomePage;

import java.util.concurrent.TimeUnit;

/**
 * Created by jiaxiong on 2019-02-24 17:34
 */
public class TestSwitch {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.get("https://www.jd.com/");
        driver.get("https://testerhome.com/");

        //Thread.sleep(1000);

        //点击京东左侧菜单中的 手机
        //WebElement phone_link = driver.findElement(By.linkText("手机"));
        //phone_link.click();

        HomePage homePage = new HomePage(driver);
        homePage.clickBanner();
        //Thread.sleep(1000);

        // 获取当前页面句柄
        String handle = driver.getWindowHandle();
        System.out.println(handle);
        // 获取所有页面的句柄，并循环判断不是当前的句柄
        for (String temhandle : driver.getWindowHandles()) {
            if (!temhandle.equals(handle)) {
                driver.switchTo().window(temhandle);
                Reporter.log("切换到窗口" + temhandle, true);
            }
        }

    }
}
