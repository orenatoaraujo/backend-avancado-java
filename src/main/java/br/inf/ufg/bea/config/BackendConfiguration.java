package br.inf.ufg.bea.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan
@EnableJpaRepositories(basePackages = "br.inf.ufg.bea")
@PropertySource(value = "classpath:/application.properties", ignoreResourceNotFound = true, name = "applicationProperties")
public class BackendConfiguration {

	private static final String[] PACKAGES = { "br.inf.ufg.bea" };

	private static final String DB_DRIVER_CLASS = "db.driver";
	private static final String DB_PASSWORD = "db.password";
	private static final String DB_URL = "db.url";
	private static final String DB_USER = "db.username";

	private static final String HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	private static final String HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";

	@Bean
	PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public DataSource dataSource(Environment env) {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty(DB_DRIVER_CLASS));
		dataSource.setUrl(env.getProperty(DB_URL));
		dataSource.setUsername(env.getProperty(DB_USER));
		dataSource.setPassword(env.getProperty(DB_PASSWORD));
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan(PACKAGES);

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		em.setJpaVendorAdapter(vendorAdapter);

		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty(HIBERNATE_HBM2DDL_AUTO, env.getProperty(HIBERNATE_HBM2DDL_AUTO));
		hibernateProperties.setProperty(HIBERNATE_DIALECT, env.getProperty(HIBERNATE_DIALECT));
		hibernateProperties.setProperty(HIBERNATE_FORMAT_SQL, env.getProperty(HIBERNATE_FORMAT_SQL));
		hibernateProperties.setProperty(HIBERNATE_SHOW_SQL, env.getProperty(HIBERNATE_SHOW_SQL));
		hibernateProperties.setProperty(HIBERNATE_NAMING_STRATEGY, env.getProperty(HIBERNATE_NAMING_STRATEGY));
		em.setJpaProperties(hibernateProperties);
		return em;
	}

}