package de.pkrause.springit;

import org.ocpsoft.prettytime.PrettyTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import de.pkrause.springit.config.SpringitProperties;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

	private static Logger log = LoggerFactory.getLogger(SpringApplication.class);

	@Autowired
	private SpringitProperties springitProperties;

	public static void main(String[] args) {
		System.out.println("Hello");
		SpringApplication.run(SpringitApplication.class, args);
	}

	/**
	 * This is something we only do in dev mode...
	 * 
	 * @return prints the welcome message
	 */
	@Bean
	@Profile("dev")
	CommandLineRunner runner() {
		return args -> {
			log.info("Welcome Message: " + springitProperties.getWelcomeMsg());
		};
	}

	@Bean
	PrettyTime prettyTime() {
		return new PrettyTime();
	}
	
}
