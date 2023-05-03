package org.example.Lab_13;

import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {
    private final Logger LOGGER = Logger.getLogger(this.getClass());


    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
        LOGGER.info("start " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
        LOGGER.info("finish " + suite.getName());
    }
}
