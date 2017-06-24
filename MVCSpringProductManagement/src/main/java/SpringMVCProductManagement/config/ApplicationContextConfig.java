package SpringMVCProductManagement.config;

import java.util.Properties;

import javax.sql.DataSource;
 
import org.hibernate.SessionFactory;

import SpringMVCProductManagement.dao.ManagerDAO;
import SpringMVCProductManagement.dao.ProductsDAO;
import SpringMVCProductManagement.dao.StaffDAO;
import SpringMVCProductManagement.dao.impl.ManagerDAOImpl;
import SpringMVCProductManagement.dao.impl.ProductsDAOImpl;
import SpringMVCProductManagement.dao.impl.StaffDAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
@Configuration
@ComponentScan("SpringMVCProductManagement.*")
@EnableTransactionManagement
// Load to Environment.
@PropertySource("classpath:ds-hibernate-cfg.properties")
public class ApplicationContextConfig {
 
 
 
  // Lưu trữ các giá thuộc tính load bởi @PropertySource.
  @Autowired
  private Environment env;
  
  
 
  @Bean
  public ResourceBundleMessageSource messageSource() {
      ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
      // Load property in message/validator.properties
      rb.setBasenames(new String[] { "messages/validator"});
      return rb;
  }
  
 
  @Bean(name = "viewResolver")
  public InternalResourceViewResolver getViewResolver() {
      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
      viewResolver.setPrefix("/WEB-INF/pages/");
      viewResolver.setSuffix(".jsp");
      return viewResolver;
  }
 
  @Bean(name = "dataSource")
  public DataSource getDataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
      dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
      dataSource.setUrl(env.getProperty("ds.url"));
      dataSource.setUsername(env.getProperty("ds.username"));
      dataSource.setPassword(env.getProperty("ds.password"));
 
      return dataSource;
  }
 
  @Autowired
  @Bean(name = "sessionFactory")
  public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
      Properties properties = new Properties();
 
      // Xem: ds-hibernate-cfg.properties
      properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
      properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
      properties.put("current_session_context_class", env.getProperty("current_session_context_class"));
      
 
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
      factoryBean.setPackagesToScan(new String[] { "SpringMVCProductManagement.entity" });
      factoryBean.setDataSource(dataSource);
      factoryBean.setHibernateProperties(properties);
      factoryBean.afterPropertiesSet();
      //
      SessionFactory sf = factoryBean.getObject();
      return sf;
  }
 
  @Autowired
  @Bean(name = "transactionManager")
  public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
 
      return transactionManager;
  }
  
  @Bean(name = "productsDAO")
  public ProductsDAO getProductsDAO() {
      return new ProductsDAOImpl();
  }
 	
  
  @Bean(name = "staffDAO")
  public StaffDAO getStaffDAO() {
      return new StaffDAOImpl();
  }
  
  @Bean(name = "managerDAO")
  public ManagerDAO getManagerDAO() {
      return new ManagerDAOImpl();
  }
}