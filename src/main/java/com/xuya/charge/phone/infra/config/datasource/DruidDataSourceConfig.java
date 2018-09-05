package com.xuya.charge.phone.infra.config.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidDataSourceConfig {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.druid.initialSize}")
	private int initialSize;

	@Value("${spring.datasource.druid.minIdle}")
	private int minIdle;

	@Value("${spring.datasource.druid.maxActive}")
	private int maxActive;

	@Value("${spring.datasource.druid.maxWait}")
	private int maxWait;

	@Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;

	@Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;

	@Value("${spring.datasource.druid.validationQuery}")
	private String validationQuery;

	@Value("${spring.datasource.druid.testWhileIdle}")
	private boolean testWhileIdle;

	@Value("${spring.datasource.druid.testOnBorrow}")
	private boolean testOnBorrow;

	@Value("${spring.datasource.druid.testOnReturn}")
	private boolean testOnReturn;

	@Value("${spring.datasource.druid.poolPreparedStatements}")
	private boolean poolPreparedStatements;

	@Value("${spring.datasource.druid.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;

	//@Value("${spring.datasource.druid.filters}")
	//private String filters;

	@Value("${spring.datasource.druid.connectionProperties}")
	private String connectionProperties;

	@Bean
	@Primary
	public DataSource dataSource() {
		DruidDataSource datasource = new DruidDataSource();

		datasource.setUrl(dbUrl);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setDriverClassName(driverClassName);
		// configuration
		datasource.setInitialSize(initialSize);
		datasource.setMinIdle(minIdle);
		datasource.setMaxActive(maxActive);
		datasource.setMaxWait(maxWait);
		datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		datasource.setValidationQuery(validationQuery);
		datasource.setTestWhileIdle(testWhileIdle);
		datasource.setTestOnBorrow(testOnBorrow);
		datasource.setTestOnReturn(testOnReturn);
		datasource.setPoolPreparedStatements(poolPreparedStatements);
		datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		//datasource.setFilters(filters);
		datasource.setConnectionProperties(connectionProperties);
		return datasource;
	}

}
