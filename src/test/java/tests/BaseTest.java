package tests;

import org.kurtosysAssessment.utils.BrowserDriver;
import org.kurtosysAssessment.utils.Config;
import org.kurtosysAssessment.utils.PropertyLoader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
        protected BrowserDriver browserDriver;
        protected Config config;

        @BeforeMethod(alwaysRun = true)
        public void setup() {
            config = new Config(new PropertyLoader("config.properties").getProperties());
            browserDriver = new BrowserDriver(config);
            browserDriver.getDriver().get(config.getUrl());
        }

        @AfterMethod(alwaysRun = true)
        public void tearDown() {
            browserDriver.getDriver().quit();
        }
}
