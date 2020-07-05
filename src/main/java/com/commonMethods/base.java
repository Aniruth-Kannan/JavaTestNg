package com.commonMethods;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public static WebDriver driver = null;

    @Parameters({"browser"})
    public static WebDriver invokeDriver(String browser) {
        System.out.println("Browser Passed is: " + browser);
        if ("chrome".equalsIgnoreCase(browser)) {
            System.out.println("Initiating chrome browser");
            System.setProperty("webdriver.chrome.driver", "D://Java/chromeDriver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("Webdriver is instantiated");
        } else if ("firefox".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.gecko.driver", "D://Java/chromeDriver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //returnData(,"user1");
        return driver;
    }

    @Parameters({"dataSource"})
    public static String returnData(String dataSource, String dataKey) {
        System.out.println("Data Source selected as: " + dataSource);
        dataKey = "user1";
        String dataValue = null;
        if (("excel").equalsIgnoreCase(dataSource)) {
            String cell1 = null;
            try {
                FileInputStream fis = new FileInputStream("D:\\Java\\seleniumExampleworkbook.xlsx");
                XSSFWorkbook workbook = new XSSFWorkbook(fis);
                XSSFSheet sheet = workbook.getSheet("seleniumExample");
                int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
                for(int i = 0; i< rowCount ;){
                    Row row = sheet.getRow(i);
                    Cell cell = row.getCell(0);
                    if((cell.toString()).equals(dataKey)){
                        dataValue = cell.toString();
                        System.out.println(cell);
                        break;
                    }
                    else{
                        i++;
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception captured" + e.getMessage());
            }
        } else if (("property file").equalsIgnoreCase(dataSource)) {
            FileInputStream fis = null;
            Properties prop = null;
            try {
                fis = new FileInputStream("testData.proerties");
                prop = new Properties();
                prop.load(fis);
                dataValue = prop.getProperty(dataKey);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return dataValue;
    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\Screenshot\\" + testCaseName + ".png";
        FileUtils.copyFile(src, new File(destinationFile));
        return destinationFile;
    }


}
