package com.api.test;

import java.io.File;

import com.utils.ConfigManager;

public class Test {
	
	public static void main(String[] args) {
		System.out.println((System.getProperty("user.dir") + File.separator + "config"
					+ File.separator + "config.properties"));
	
	System.out.println(ConfigManager.getConfig().getProperty("URL"));
	
	}

}
