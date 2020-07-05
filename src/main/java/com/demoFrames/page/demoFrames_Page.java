package com.demoFrames.page;

import org.openqa.selenium.By;

public interface demoFrames_Page {

    By buttonSingleIframe = By.xpath("//a[@class='analystic' and (text()='Single Iframe ')]");
    By buttonIframeWithInAIframe = By.xpath("//a[@class='analystic' and (text()='Iframe with in an Iframe')]");
    By iframeSingleFrame = By.xpath("//iframe[@id='singleframe']");
    By textBoxSingleFrame = By.xpath("//div[@class='col-xs-6 col-xs-offset-5']/input");

    By iframeFirstFrameOfIframeInAIframe = By.xpath("//iframe[@src='MultipleFrames.html']");
    By iframeSecondFrameOfIframeInAIframe = By.xpath("//iframe[@src='SingleFrame.html']");


}
