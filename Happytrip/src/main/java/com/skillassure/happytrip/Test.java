package com.skillassure.happytrip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Test {
	private static Logger log;

	static int x=4;

	public static void main(String[] args) {

	log= LogManager.getLogger(Test.class.getName());

	log.debug("Execution Started");

	log.info("This is info level");

	if(5<x)

	{

	log.debug("Condition Successfull");

	}

	else {

	log.error("Condition Failed");

	}
	}
}