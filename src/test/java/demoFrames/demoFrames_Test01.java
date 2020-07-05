
package demoFrames;

import com.commonMethods.commonMethods;
import com.demoRegister.methods.demoRegister_Steps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.demoFrames.page.demoFrames_Page.*;

class demoFrames_Test01 {

    private static WebDriver driver = null;

    @BeforeClass
    public static WebDriver invokeDriver() {
        return driver = demoRegister_Steps.invokeDriverFordemoRegister();
    }

    @Test(priority = 0)
    public static void verifyControlToSingleFrameAndTypeTextInFrame() {
        commonMethods.openUrl(driver, "demo.automationtesting.in/Frames.html", false);
        commonMethods.waitForElement(driver, buttonSingleIframe);
        commonMethods.checkElementIsPresent(driver, buttonSingleIframe);
        commonMethods.clickElement(driver, buttonSingleIframe);
        commonMethods.switchControlToIframeByName(driver, iframeSingleFrame);
        commonMethods.checkElementIsPresent(driver, textBoxSingleFrame);
        commonMethods.typeTextInTextBox(driver, textBoxSingleFrame, "Hello All!");
        commonMethods.verifyTextInField(driver, textBoxSingleFrame, "Hello All!");
    }

    @Test(priority = 1)
    public static void verifyControlToFrameWithAnIframe(){
        commonMethods.checkElementIsPresent(driver,buttonIframeWithInAIframe);
        commonMethods.clickElement(driver,buttonIframeWithInAIframe);
        commonMethods.switchControlToIframeByName(driver,iframeFirstFrameOfIframeInAIframe);
        commonMethods.switchControlToIframeByName(driver,iframeSecondFrameOfIframeInAIframe);
        commonMethods.checkElementIsPresent(driver,textBoxSingleFrame);
        commonMethods.typeTextInTextBox(driver,textBoxSingleFrame,"Hello All!");
        commonMethods.verifyTextInField(driver,textBoxSingleFrame,"Hello All!");

    }


    @AfterClass
    public static void exitTest(){
        commonMethods.closeDriverConnection(driver);
    }
}

