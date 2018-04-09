/**
 * 
 */
package com.oto.kyc.config.persistence;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author thuyntp
 *
 */
@Configuration
@PropertySource({"classpath:/datasource/db-develop.properties"})
@EnableJpaRepositories(basePackages = "com.oto.kyc.dao",
		entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager")
public class PersistenceConfigurer {
	
	@Autowired
	private Environment env;
	
	/**
     * Initialization LocalContainerEntityManagerFactoryBean for Common database.
     * @return {@link LocalContainerEntityManagerFactoryBean} instance
     */
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] {"com.oto.kyc.model", "com.oto.kyc.model.base"});
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("hibernate.order_inserts", "true");
		properties.put("hibernate.order_updates", "true");
		properties.put("hhibernate.jdbc.batch_size", "2");
		
		em.setJpaPropertyMap(properties);
		
		return em;
	}
	
	/**
     * Initialization DataSource for Common database.
     * @return {@link DataSource} instance
     */
    @Primary
    @Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		
		return dataSource;
	}

    /**
     * Initialization PlatformTransactionManager for Common database.
     * @return {@link PlatformTransactionManager} instance
     */
    @Primary
    @Bean
    public PlatformTransactionManager transactionManager() {
    	JpaTransactionManager transactionManager = new JpaTransactionManager();
    	transactionManager.setEntityManagerFactory(entityManager().getObject());
    	return transactionManager;
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    	return new PersistenceExceptionTranslationPostProcessor();
    }
}
