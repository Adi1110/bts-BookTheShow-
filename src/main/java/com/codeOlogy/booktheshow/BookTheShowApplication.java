package com.codeOlogy.booktheshow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookTheShowApplication {

	public static void main(String[] args) {
		final Logger logger = LogManager.getLogger(BookTheShowApplication.class.getName());
		
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warning message");
		logger.error("This is an error message");
		logger.fatal("This is a fatal message");
		
		SpringApplication.run(BookTheShowApplication.class, args);
	}

}
