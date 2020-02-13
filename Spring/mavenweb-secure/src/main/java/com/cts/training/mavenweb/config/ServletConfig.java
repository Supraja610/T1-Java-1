package com.cts.training.mavenweb.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.cts.training.mavenweb")
@PropertySource("classpath:database.properties")
public class ServletConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public DataSource comboPooledDataSource() {
		// highly configurable as compared to DriverManagerDataSource
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		// JDBC Config
		
		try {
			comboPooledDataSource.setDriverClass(this.env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		comboPooledDataSource.setJdbcUrl(this.env.getProperty("jdbc.url"));
		comboPooledDataSource.setUser(this.env.getProperty("jdbc.user"));
		comboPooledDataSource.setPassword(this.env.getProperty("jdbc.password"));
		
		// Combo Pooled Config
		comboPooledDataSource.setInitialPoolSize(Integer.parseInt(this.env.getProperty("combopool.initialPoolSize")));
		comboPooledDataSource.setMaxPoolSize(Integer.parseInt(this.env.getProperty("combopool.maxPoolSize")));
		comboPooledDataSource.setMinPoolSize(Integer.parseInt(this.env.getProperty("combopool.minPoolSize")));
		comboPooledDataSource.setMaxIdleTime(Integer.parseInt(this.env.getProperty("combopool.maxIdleTime")));
		
		return comboPooledDataSource;
		
	}
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// inject dependency
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
}
