package com.example.employeemanagement.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.example.employeemanagement.department.repository",
    entityManagerFactoryRef = "departmentEntityManagerFactory",
    transactionManagerRef = "departmentTransactionManager"
)
public class DepartmentDataSourceConfig {

    @Bean(name = "departmentDataSource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "departmentEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("departmentDataSource") DataSource dataSource) {
        return builder
            .dataSource(dataSource)
            .packages("com.example.employeemanagement.department.entity")
            .persistenceUnit("department")
            .build();
    }

    @Bean(name = "departmentTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("departmentEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
