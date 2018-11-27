package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableJpaRepositories(transactionManagerRef = "myTm", basePackages = "com.example.demo", entityManagerFactoryRef = "emf")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean(name = "emf")
    public EntityManagerFactory entityManagerFactory(@Qualifier("myDataSource") DataSource dataSource) {
        Properties properties = new Properties();
        properties.setProperty("show_sql", "false");
        properties.setProperty("hibernate.cache.use_second_level_cache", "false");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceUnitName("myPersistenceUnit");
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("demo", "com.example.demo");
        factory.setDataSource(dataSource);
        factory.setJpaProperties(properties);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean(name = "myDataSource")
    @ConfigurationProperties(prefix = "my.datasource")
    public DataSource datasource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }

    @Bean(name = "myTm")
    @Autowired
    public PlatformTransactionManager accountTransactionManager(@Qualifier("emf") EntityManagerFactory aemf) {
        return new JpaTransactionManager(aemf);
    }

}
