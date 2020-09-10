package com.negi.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;



@Configuration
public class DBConfig {/*
	
	private static final Logger LOG = LoggerFactory.getLogger(DBConfig.class);
	
	@ConfigurationProperties(prefix= "spring.datasource1")
	@Bean(name="db1")
	@Primary
	public DataSource dataSource1(@Value("${spring.datasource1.username}") String schema)
	{
		
		DataSource dataSource = DataSourceBuilder.create().build();
		
		return dataSource;
	}
	
	@ConfigurationProperties(prefix= "spring.datasource2")
	@Bean(name="db2")
	public DataSource destinationDataSource1(@Value("${spring.datasource2.username}") String schema)
	{
		
		DataSource dataSource = DataSourceBuilder.create().build();
		
		return dataSource;
	}

*/}
