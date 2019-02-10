package io.github.gravetii.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class ConfigReader {

  private static final Logger logger =
      LoggerFactory.getLogger(ConfigReader.class.getCanonicalName());

  private Properties properties = new Properties();

  ConfigReader() {
    try {
      InputStream stream = ClassLoader.getSystemResourceAsStream("config.properties");
      properties.load(stream);
    } catch (IOException e) {
      logger.error("Unable to load properties, exiting.");
      System.exit(1);
    }
  }

  String getStringProperty(String key) {
    return properties.getProperty(key);
  }

  Integer getIntegerProperty(String key) {
    String value = properties.getProperty(key);
    return Integer.parseInt(value);
  }

  boolean getBooleanProperty(String key, boolean defaultValue) {
    String value = properties.getProperty(key);
    return Boolean.parseBoolean(value);
  }
}
