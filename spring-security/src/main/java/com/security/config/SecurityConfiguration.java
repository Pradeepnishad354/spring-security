package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http/* .csrf().disable() */
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
		.authorizeRequests()
		.antMatchers("/public/**").hasRole("NORMAL")
		.antMatchers("/user/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
	}
	
	// ROLE-high level -:Read
	//Authority-permission
	//ADMIN-READ,WRITE,UPDATE

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("pradeep").password(this.passwordEncoder().encode("12345")).roles("NORMAL");
		
		auth.inMemoryAuthentication().withUser("saurabh").password(this.passwordEncoder().encode("123456")).roles("ADMIN");
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	

	
	
	
	
	
	
	

}
