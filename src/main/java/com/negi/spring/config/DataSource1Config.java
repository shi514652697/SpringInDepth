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
@EnableJpaRepositories( entityManagerFactoryRef="db1EntityMangerFactory",
                        transactionManagerRef="db1TransactionManger",
                        basePackages="com.negi.spring.repository1")*/

public class DataSource1Config {/*
	
	@Bean(name="db1EntityMangerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean dbSource1EntityMangerFactory(final EntityManagerFactoryBuilder builder,
			    final @Qualifier("db1") DataSource dataSource) 
	{
		return builder
				.dataSource(dataSource)
				.packages("com.negi.spring.data1")
				.persistenceUnit("db1")
				.build();
	}
	
	@Bean(name="db1TransactionManger")
	@Primary
	public PlatformTransactionManager dbSource1TransactionManager(@Qualifier("db1EntityMangerFactory") EntityManagerFactory db1EntityMangerFactory)
	{
		return new JpaTransactionManager(db1EntityMangerFactory);
	}


*/}
