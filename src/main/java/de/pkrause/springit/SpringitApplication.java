package de.pkrause.springit;

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
import de.pkrause.springit.model.Comment;
import de.pkrause.springit.model.Link;
import de.pkrause.springit.repository.CommentRepository;
import de.pkrause.springit.repository.LinkRepository;

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
	
	/**
	 * @return adds some test data
	 */
	@Bean
	@Profile("dev")
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
		return args -> {
			Link link = new Link("Getting Started", "https://therealdanvega.com");
			linkRepository.save(link);
			Comment comment = new Comment("Nice Course", link);
			link.addComment(comment);

			System.out.println(link.toString());
			System.out.println(link.getComments());
		};
	}

}
