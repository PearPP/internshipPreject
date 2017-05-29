package com.oceantest.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.oceantest.services")
@EnableTransactionManagement
public class PersistenceJPAConfig {

//	@Bean
//	public JpaTransactionManager jpaTransMan(){
//		JpaTransactionManager jtManager = new JpaTransactionManager(
//				getEntityManagerFactoryBean().getObject());
//		return jtManager;
//	}
//	@Bean
//	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
//		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
//		lcemfb.setDataSource(getDataSource());
////		lcemfb.setPersistenceUnitName("localContainerEntity");
//		LoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
//		lcemfb.setLoadTimeWeaver(loadTimeWeaver);
//		lcemfb.setJpaProperties(additionalProperties());
//		return lcemfb;
//	}
	
   @Bean
   public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(getDataSource());
      em.setPackagesToScan(new String[] { "com.oceantest.services" });
      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);
      em.setJpaProperties(additionalProperties());
 
      return em;
   }
 
   @Bean
   public DataSource getDataSource(){
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("org.postgresql.Driver");
//      dataSource.setUrl("jdbc:postgresql://locahost:5432/nbs");
      dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/trainingapp");
//      dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/oceantest");
//      dataSource.setUsername( "oceantest" );
      dataSource.setUsername( "trainingapp" );
      dataSource.setPassword( "nopass" );
      return dataSource;
   }
 
   @Bean
   public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(emf);
 
      return transactionManager;
   }
 
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
      return new PersistenceExceptionTranslationPostProcessor();
   }
 
   Properties additionalProperties() {
      Properties properties = new Properties();
//      properties.setProperty("hibernate.hbm2ddl.auto", "update");
//      properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//      properties.setProperty("hibernate.hbm2ddl.auto", "create");
      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
      properties.setProperty("hibernate.show_sql", "true");
      properties.setProperty("hibernate.format_sql", "true");
      properties.setProperty("hibernate.cache.use_second_level_cache", "true");
      
      return properties;
   }
}
