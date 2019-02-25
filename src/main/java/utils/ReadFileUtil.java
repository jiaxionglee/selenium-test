package utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by jiaxiong on 2019-02-24 10:28
 */
public class ReadFileUtil {

    public static Iterator<Object[]> readCsvFile(String filePath) throws Exception {
        List<Object[]> dataArray = new ArrayList<Object[]>();
        Reader in = new FileReader(filePath);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

        for (CSVRecord record : records) {
            List<Object> rowList = new ArrayList<Object>();
            Iterator i = record.iterator();
            while (i.hasNext()) {
                rowList.add(i.next());
            }
            Object[] rowArray = rowList.toArray();
            dataArray.add(rowArray);
        }
        return dataArray.iterator();
    }

    public static String readYamlFile(String path, String attribute) throws IOException {
        Yaml yaml = new Yaml();
        FileInputStream fileInputStream = new FileInputStream(path);
        Map map = yaml.loadAs(fileInputStream, Map.class);
        fileInputStream.close();
        return (String) map.get(attribute);
    }

    public static String getPath(String partPath) throws UnsupportedEncodingException {
        String path = ReadFileUtil.class.getResource(partPath).getPath();
        return URLDecoder.decode(path, "UTF-8");
    }

}
