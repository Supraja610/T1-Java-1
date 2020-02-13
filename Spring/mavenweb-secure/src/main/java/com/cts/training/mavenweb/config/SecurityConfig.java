package com.cts.training.mavenweb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


// Configuration class to define security Rules
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// WebSecurityConfigurerAdapter : provides 3 methods : configure
	
	// dependency
	@Autowired
	private DataSource dataSource;
	
	// configure the credentials repository
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		/********** JDBC Authentication ***************/
		
		// default schema
		auth.jdbcAuthentication().dataSource(dataSource);
		
		// custom schema
		/*auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("")  // for reading username and password (authentication)
			.authoritiesByUsernameQuery(""); // for reading roles (authorazation)
		*/
		
		
		/*********** in-memory auth ***********/
		/*
		// User : allows to create user
		UserBuilder builder =  User.withDefaultPasswordEncoder();
		
		// some hardcoded credentials (user)
		// in-memory repository
		auth.inMemoryAuthentication()
			.withUser(builder.username("First").password("abc").roles("EMPLOYEE"))
			.withUser(builder.username("Second").password("abc").roles("EMPLOYEE","MANAGER"))
			.withUser(builder.username("Third").password("abc").roles("EMPLOYEE","ADMIN"));
		*/	
	}
	
	// secure the application : define the accessibility rule
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		/************ Without Role Authentication ***************/
		// all request must be authenticated
		/*http.authorizeRequests() // start  defining the rule
			.anyRequest()	// all url request
			.authenticated()
		.and() //how authentication should take place (and() returns a new http)
			// .httpBasic();
			// .formLogin();
			.formLogin() // want to form based authentication
			.loginPage("/custom-login") // custom login form
			.loginProcessingUrl("/validate") // implementation is provided free
			.permitAll() // allow all users to access login-page
		.and()
			.logout(); // implementation is provided free (/logout : default url)
			*/
	/*************** With Role Authentication *****************/	
	http.authorizeRequests() // start  defining the rule
		.antMatchers("/").hasRole("EMPLOYEE") // any request for root (/) is accessible to users under role EMPLOYEE
		.antMatchers("/manager/**").hasRole("MANAGER")
		.antMatchers("/admin/**").hasRole("ADMIN")
	.and() //how authentication should take place (and() returns a new http)
		// .httpBasic();
		// .formLogin();
		.formLogin() // want to form based authentication
		.loginPage("/custom-login") // custom login form
		.loginProcessingUrl("/validate") // implementation is provided free
		.permitAll() // allow all users to access login-page
	.and()
		.logout() // implementation is provided free (/logout : default url)
		.permitAll()
	.and()
		.exceptionHandling()
			.accessDeniedPage("/custom-error");
	}
}


/***********
 * {bcrypt}$2a$04$ON6IrjLRg7WWRB5k/E8sfOvHwBiCz.8kmDTVywU/WUC5UZoJm0OiO
 */









