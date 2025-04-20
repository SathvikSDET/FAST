package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

	private static ConfigManager config;
	private Properties properties;

	public static ConfigManager getConfig() {

		if (config == null) {
			synchronized (ConfigManager.class) {
				if (config == null) {
					config = new ConfigManager();
				}
			}
		}

		return config;

	}

	private ConfigManager() {
		loadProperties();
	}

	private void loadProperties() {
		properties = new Properties();
		try {
			FileInputStream file = new FileInputStream((System.getProperty("user.dir") + File.separator + "config"
					+ File.separator + "config.properties"));
			properties.load(file);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public boolean getBooleanProperty(String key, boolean defaultValue) {
		return Boolean.parseBoolean(properties.getProperty(key));

	}

}
