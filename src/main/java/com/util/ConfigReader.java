package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public Properties init_prop(String filePath) {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(filePath);
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
