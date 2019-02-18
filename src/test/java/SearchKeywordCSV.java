import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
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

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiaxiong on 2019-02-17 14:20
 */
public class SearchKeywordCSV {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("-–start-maximized");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
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
        //driver.quit();
    }

    @DataProvider
    public Iterator<Object[]> getData() throws Exception {

        String filePath=this.getClass().getResource("/data.csv").getPath();
        System.out.println(filePath);
        return readCsvFile(filePath);
    }

    private void assertTopic(String value, SerachResultPage serachResultPage) {

        String actualTopic = "";
        for (WebElement topic : serachResultPage.getTopics()) {
            actualTopic = topic.getText().trim().toLowerCase();
            Assert.assertTrue(actualTopic.contains(value), "期待的标题不含含" + value + "实际标题是：" + actualTopic);
        }
    }

    private Iterator<Object[]> readCsvFile(String filePath) throws Exception {
        List<Object[]> dataArray=new ArrayList<Object[]>();
        Reader in= new FileReader(filePath);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

        for (CSVRecord record:records){
            List<Object> rowList= new ArrayList<Object>();
            Iterator i = record.iterator();
            while (i.hasNext()){
                rowList.add(i.next());
            }
            Object [] rowArray = rowList.toArray();
            dataArray.add(rowArray);
        }
        return dataArray.iterator();
    }
}
