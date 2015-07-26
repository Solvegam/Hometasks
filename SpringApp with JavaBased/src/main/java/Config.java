import firstPack.DAO.ContactDao;
import firstPack.DAO.HobbyDao;
import firstPack.DAO.MessageDao;
import firstPack.DAO.PlaceDao;
import firstPack.JavaContactService;
import firstPack.rootClasses.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.hibernate.SessionFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Stas on 04.07.2015.
 */
@Configuration
public class Config {
    @Bean
    public JavaContactService service ()
    {
        return new JavaContactService();
    }
    @Bean
    public ContactDao contactDAO ()
    {
        return new ContactDao();
    }
    @Bean
    public HobbyDao hobbyDAO ()
    {
        return new HobbyDao();
    }
    @Bean
    public PlaceDao placeDAO ()
    {
        return new PlaceDao();
    }
    @Bean
    public MessageDao messageDAO ()
    {
        return new MessageDao();
    }

    @Bean
    public DataSource myDataSource ()
    {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/springapp");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory ()
    {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(myDataSource());
        sessionFactory.setPackagesToScan("firstPack/rootClasses");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager (final SessionFactory sessionFactory)
    {
        final HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    final Properties hibernateProperties () {

        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto","create");
        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        return hibernateProperties;
    }

}
