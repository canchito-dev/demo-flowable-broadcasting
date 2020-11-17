package org.flowable.broadcasting.demo.demoflowablecore.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.common.engine.impl.persistence.StrongUuidGenerator;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.flowable.spring.boot.ProcessEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;

import javax.sql.DataSource;
import java.util.Arrays;

@Primary
@Configuration
@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE) // Makes sure that this configuration will be processed last by Spring Boot
@AutoConfigureAfter(ProcessEngineAutoConfiguration.class)
public class CustomEngineConfiguration {
	
	@Primary
	@Bean
    @ConfigurationProperties("flowable.datasource")
    public DataSourceProperties flowableDataSourceProperties() {
        return new DataSourceProperties();
    }
	
	@Primary
	@Bean
	public HikariDataSource flowableDataSource(
			@Qualifier("flowableDataSourceProperties") DataSourceProperties flowableDataSourceProperties
	) {
		return flowableDataSourceProperties
				.initializeDataSourceBuilder()
				.type(HikariDataSource.class)
                .build();
	}
	
	@Bean
    EngineConfigurationConfigurer<SpringProcessEngineConfiguration> engineConfigurationConfigurer(
			@Qualifier("flowableDataSource") DataSource dataSource
	) {
		return engineConfiguration -> {
			/**
             * Flowable DOCS (v6.5.0)'s user guide - UUID ID generator for high concurrency
             * https://flowable.com/open-source/docs/bpmn/ch18-Advanced/#uuid-id-generator-for-high-concurrency
             **/
			engineConfiguration.setIdGenerator(new StrongUuidGenerator());
			
			/**
             * Flowable DOCS (v6.5.0)'s user guide - Database configuration
             * https://flowable.com/open-source/docs/bpmn/ch03-Configuration/#database-configuration
			 *
			 * The data source that is constructed based on the provided JDBC properties will have the default MyBatis connection pool settings. The following attributes can
			 * optionally be set to tweak that connection pool (taken from the MyBatis documentation):
			 * - jdbcMaxActiveConnections: The number of active connections that the connection pool at maximum at any time can contain. Default is 10.
			 * - jdbcMaxIdleConnections: The number of idle connections that the connection pool at maximum at any time can contain.
			 * - jdbcMaxCheckoutTime: The amount of time in milliseconds a connection can be checked out from the connection pool before it is forcefully returned. Default is 20000 (20 seconds).
			 * - jdbcMaxWaitTime: This is a low level setting that gives the pool a chance to print a log status and re-attempt the acquisition of a connection in the case that it is taking unusually
			 * 					  long (to avoid failing silently forever if the pool is misconfigured) Default is 20000 (20 seconds).
             **/
			engineConfiguration.setDataSource(dataSource);
			
			/**
             * Flowable DOCS (v6.5.0)'s user guide - Event handlers
             * https://flowable.com/open-source/docs/bpmn/ch03-Configuration/#event-handlers
             **/
			engineConfiguration.setEventListeners(Arrays.<FlowableEventListener>asList(new CustomEventHandler()));
		};
	}
}