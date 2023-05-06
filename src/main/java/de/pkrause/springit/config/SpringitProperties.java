package de.pkrause.springit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("springit")
public class SpringitProperties {
 
    /**
     * This is our welcome message. Who would have thought...
     */
    @Getter @Setter
    private String welcomeMsg = "Hello World";
    
    
}
