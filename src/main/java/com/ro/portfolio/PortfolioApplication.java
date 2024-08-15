package com.ro.portfolio;

import com.ro.portfolio.config.ApplicationProperties;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.TimeZone;

/**
 * Entry Point the Portfolio Application
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
@EnableConfigurationProperties(ApplicationProperties.class)
public class PortfolioApplication {

	/**
	 * Main function to start the portfolio application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	/**
	 * To set the Timezone on the boot of the application
	 */
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
