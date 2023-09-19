package de.pkrause.springit.securtity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    private UserDetailsServiceImpl userDetailsService;

    public SecurityConfiguration(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth = http
                .getSharedObject(AuthenticationManagerBuilder.class);
        auth.userDetailsService(userDetailsService);
        return auth.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers(EndpointRequest.to("info")).permitAll()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasAnyRole("ADMIN")
                .antMatchers("/actuator/").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .antMatchers("/link/submit").hasRole("USER"))
                .formLogin(login -> login
                        .loginPage("/login")
                        .permitAll()
                        .usernameParameter("email"))
                .logout(withDefaults())
                .rememberMe(withDefaults());
        return http.build();
    }

    // @Bean
    // public WebSecurityCustomizer webSecurityCustomizer() {
       
    //     return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
    // }

}
