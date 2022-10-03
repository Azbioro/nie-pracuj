package pl.niepracuj.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jca.support.LocalConnectionFactoryBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration  //konfiguracja z local.properties
@PropertySource("classpath:application.properties") //dzięki temu wie, że ma się dostać do app.properties
public class DatabaseConfiguration {


    // ustawione datasourcy z local.properties
    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Value("${jpa.properties.hibernate.dialect}")
    private String dialect;

    @Value("${jpa.hibernate.ddl-auto}")
    private String mode;

    @Value("${packages.to.scan}")
    private String packages;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);
        return driverManagerDataSource;
    }

    @Bean //konfiguracja logowania do bazy danych
    public LocalContainerEntityManagerFactoryBean getEntityManager() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(getDataSource());
        entityManagerFactoryBean.setPackagesToScan(packages); //dodane pakiety do skanowania, żeby wiedział co ma skanować - eliminacja błędu
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter()); //dzięki temu będzie można korzystać z hibernate
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        return entityManagerFactoryBean;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", mode);
        properties.setProperty("hibernate.dialect", dialect);
        return properties;

    }
}
