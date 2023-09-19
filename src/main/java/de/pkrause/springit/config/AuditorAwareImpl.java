package de.pkrause.springit.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import de.pkrause.springit.model.User;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        
        // "THIS IS JUST A DEVELOPMENT PROBLEM..." Famous Last Words
        if( SecurityContextHolder.getContext().getAuthentication() == null) return Optional.of("TEST_DATA");

        return Optional.of(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail());
    }

}
