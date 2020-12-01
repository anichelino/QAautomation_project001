package com.testngdemo.automation.functional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.testnegdemo.automation.singletests.TestAsSeparated;

public abstract class TestSuitesBases {

	protected static Logger loggerTest = LogManager.getLogger(TestAsSeparated.class);

	protected String baseUrl = "https://www.google.com";

}
