package com.JT_project.GradingSystem.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // add support for JDBC ... no more hardcoded users :-)

	@Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
       // define query to retrieve a user by username
       jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username,password,active from users where username=?");
      
       // define query to retrieve the authorities/roles by username
       jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
               "select u.username,r.role from users u,roles r where u.user_id=r.user_id and username=?");
        return jdbcUserDetailsManager;
   }
	
@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(configurer ->
    configurer
//            .requestMatchers(HttpMethod.GET, "/api/prof").hasRole("PROF")
//            .requestMatchers(HttpMethod.GET, "/api/student").hasRole("STUDENT")
            .requestMatchers(HttpMethod.POST,"/api/add_studentUser").permitAll()
            .requestMatchers(HttpMethod.POST,"/api/add_professorUser").permitAll()
            .requestMatchers(HttpMethod.POST,"/api/add_profDetails/{user_id}").hasRole("PROF")
            .requestMatchers(HttpMethod.POST,"/api/add_studentDetails/{user_id}").hasRole("STUDENT")
            
);

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
