package com.example.demo;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
//import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.math.NumberUtils;

@SpringBootApplication
@RestController
public class ConsoleTestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsoleTestProjectApplication.class, args);

	}

	@GetMapping("/hello")
	public String index() {
		return "hello world";
	}

	/**
	 * converts the given number into readable string format with precision
	 * 
	 * @param num       number to be converted
	 * @param precision precision required in output string
	 * @return readble string format with given precision
	 */
	public String displayNum(double num, int precision) {
		return String.format("%." + precision + "f", num);
	}

	/**
	 * converts the given number into readable string format with default precision
	 * 2
	 * 
	 * @param num number to be converted
	 * @return readble string format with given precision
	 */
	public String displayNum(double num) {
		return displayNum(num, 2);
	}

}
