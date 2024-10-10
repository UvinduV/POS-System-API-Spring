package lk.ijse.possystemapispring.config;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "lk.ijse.possystemapispring")
public class webAppRootConfig {

    @Bean
    public DataSource dataSource() { //DB configuration
        var dmds=new DriverManagerDataSource();
        dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dmds.setUrl("jdbc:mysql://localhost:3306/posSystemAPISpring?createDatabaseIfNotExist=true");
        dmds.setUsername("root");
        dmds.setPassword("Ijse@1234");
        return dmds;

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() { //ORM configuration

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean(); //entity manager factory bootstrap kara atha.
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("lk/ijse/possystemapispring/entity");
        factory.setDataSource(dataSource());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

}
