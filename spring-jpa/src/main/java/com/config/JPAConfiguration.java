package com.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.pool.HikariPool;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class JPAConfiguration {
	@Bean
	public DataSource dataSource(){
		//EmbeddedDatabaseBuilder builder=new EmbeddedDatabaseBuilder();
		//return builder.setType(EmbeddedDatabaseType.HSQL).build();
		//DriverManagerDataSource dataSource=new DriverManagerDataSource();
		//dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//dataSource.setUrl("jdbc:mysql://localhost:3306/springboot_jpa");
		//dataSource.setUsername("root");
		//dataSource.setPassword("141203121");
		//return dataSource;
		HikariConfig config=new HikariConfig();
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/springboot_jpa?serverTimezone=Asia/Tokyo");
		config.setUsername("root");
		config.setPassword("141203121");
		config.setMaximumPoolSize(10);
		//config.setConnectionTimeout(connectionTimeoutMs);
		HikariPool pool=new HikariPool(config);
		return pool.getUnwrappedDataSource();
		
		 
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		HibernateJpaVendorAdapter vendorAdapter=new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.entity");
		factory.setDataSource(dataSource());
		return factory;
	}
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
		JpaTransactionManager txManager=new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		return txManager;
	}

}
