package org.example.Lab_14;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static org.example.Lab_12.WebDriverSupplier.driver;

public class AllureListener implements ITestListener {
    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        LOGGER.info("starting method: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        LOGGER.error(result.getName()+" onTestFailure");
        makeScreenShot();
    }
    @Attachment(value="Page screen", type="image/png")
    private byte[] makeScreenShot(){
        LOGGER.error("makeScreenShot");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
