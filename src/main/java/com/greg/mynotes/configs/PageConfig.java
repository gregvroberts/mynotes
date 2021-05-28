package com.greg.mynotes.configs;

/**
 *
 * Created by Gregory Roberts on 5/27/21
 *
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PageConfig {

    /**
     * BCryptPasswordEncoder bean
     * @return BCPE obj
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    /**
     * Register the controllers and the views with an override method
     * @param registry view controller registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/notes").setViewName("notes");
        registry.addViewController("/").setViewName("notes");
        registry.addViewController("/login").setViewName("login");
    }




}