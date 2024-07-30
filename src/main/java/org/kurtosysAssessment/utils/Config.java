package org.kurtosysAssessment.utils;

import java.util.Properties;

public class Config {
    private final String url;
    private final String browser;

    public Config(Properties properties) {
        url = properties.getProperty("url");
        browser = properties.getProperty("browser");
    }

    public String getUrl() {
        return url;
    }

    public String getBrowser() {
        return browser;
    }
}
