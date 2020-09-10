package com.negi.spring.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/*@Configuration
@EnableJpaRepositories( entityManagerFactoryRef="db2EntityMangerFactory",
transactionManagerRef="db2TransactionManger",
basePackages="com.negi.spring.repository2")*/
public class DataSource2Config {/*
	

	
	@Bean(name="db2EntityMangerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean dbSource1EntityMangerFactory(final EntityManagerFactoryBuilder builder,
			    final @Qualifier("db2") DataSource dataSource) 
	{
		return builder
				.dataSource(dataSource)
				.packages("com.negi.spring.data2")
				.persistenceUnit("db2")
				.build();
	}
	
	@Bean(name="db2TransactionManger")
	@Primary
	public PlatformTransactionManager dbSource1TransactionManager(@Qualifier("db2EntityMangerFactory") EntityManagerFactory db2EntityMangerFactory)
	{
		return new JpaTransactionManager(db2EntityMangerFactory);
	}




*/}
