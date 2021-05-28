package com.greg.mynotes.configs;

/**
 *
 * Created by Gregory Roberts on 5/27/21
 *
 */

import com.greg.mynotes.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// import com.greg.mynotes.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfiguration {

    @Autowired
    CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Bean for the Spring Security UserDetailsService
     * @return obj
     */
    @Bean
    public UserDetailsService jpaUserDetails() {
        return new CustomUserDetailsService();
    }

    /**
     * manage authentication method
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetailsService userDetailsService = jpaUserDetails();
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    /**
     * Override method for securing http requests
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAuthority("ADMIN").antMatchers("/h2/console").permitAll()
                .antMatchers("/login").permitAll().antMatchers("/signup").permitAll().antMatchers("/notes")
                .hasAuthority("ADMIN").antMatchers("/notes/**").hasAuthority("ADMIN").anyRequest().authenticated().and()
                .csrf().disable().formLogin().successHandler(customizeAuthenticationSuccessHandler).loginPage("/login")
                .failureUrl("/login?error=true").usernameParameter("email").passwordParameter("password").and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and()
                .exceptionHandling();
    }
}