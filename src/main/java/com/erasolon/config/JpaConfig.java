/**
 * 
 */
package com.erasolon.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author operator_erasolon
 *
 */
@Configuration
@EnableJpaRepositories(basePackages="com.erasolon.repository")
@EnableTransactionManagement
public class JpaConfig {
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public EntityManagerFactory  entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean factory= new LocalContainerEntityManagerFactoryBean();
		factory.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
		factory.setPersistenceUnitName("spring-mvc-httpsecurity-userservicedetails");
		factory.setDataSource(dataSource);
		//factory.setPackagesToScan("com.erasolon.entity");
		factory.afterPropertiesSet();
		
		return factory.getObject();
		
	}
	
	@Bean
	  public PlatformTransactionManager transactionManager() {
	
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory());
	    return txManager;
	    
	  }

}
