package org.kurtosysAssessment.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    private final Properties properties = new Properties();

    public PropertyLoader(String fileName) {
        loadFile(fileName);
    }

    void loadFile(String fileName) {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }
}
