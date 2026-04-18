package com.portfolio.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties props = new Properties();

    static {
        try (InputStream is = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (is == null) throw new RuntimeException("config.properties not found on classpath");
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        // System property wins over config file (allows -D overrides)
        String sysProp = System.getProperty(key);
        return (sysProp != null && !sysProp.isBlank()) ? sysProp : props.getProperty(key, "");
    }

    public static String getBaseUrl()       { return get("base.url"); }
    public static String getBrowser()       { return get("browser"); }
    public static boolean isHeadless()      { return Boolean.parseBoolean(get("headless")); }
    public static int getImplicitWait()     { return Integer.parseInt(get("implicit.wait")); }
    public static int getExplicitWait()     { return Integer.parseInt(get("explicit.wait")); }
    public static int getPageLoadTimeout()  { return Integer.parseInt(get("page.load.timeout")); }
}
