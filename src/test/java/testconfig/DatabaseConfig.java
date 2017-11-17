package testconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db/db.dev.properties")
public class DatabaseConfig {

    @Autowired
    Environment environment;

    @Bean
    DataSource dataSource(){
        return new DriverManagerDataSource(
                environment.getProperty("datasource.url"),
                environment.getProperty("datasource.user"),
                environment.getProperty("datasource.password")

        );
    }

    @Bean
    PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
