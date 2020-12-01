package com.testnegdemo.automation.singletests;

import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestAsSeparated {

	private static final Logger loggerTest = LogManager.getLogger(TestAsSeparated.class);

	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*
		 * Properties props = new Properties(); props.load( new FileInputStream(
		 * "C:\\Users\\F92613C\\workspace\\prova1\\src\\main\\resources\\log4j.properties"
		 * )); PropertyConfigurator.configure(props);
		 */
		
		loggerTest.error("We've just greeted the user!");
		loggerTest.info("I am entered in the main application");
		loggerTest.debug("I am entered in the main application 2");
		System.out.println("message ending");
	}

}
