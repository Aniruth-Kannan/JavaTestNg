import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.IReporter;

public class ExtentReporterNG implements IReporter{

    static ExtentReports extent;

    public static ExtentReports getReportObject() {
        String path = System.getProperty("user.dir")+"\\TestNgReports\\index.html";
        System.out.println("TestNg Extent Reports Path "+path);
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("TestNg Fast Track Assignment Results");
        reporter.config().setDocumentTitle("TestNg Fast Track Assignment Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Aniruth Kannan");
        return extent;
    }





}
