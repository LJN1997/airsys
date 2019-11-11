package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据库配置
 * （1）要告诉配置类你的配置信息的位置@PropertySource
 * （2）利用IOC功能注入配置信息@Value
 * @author Administrator
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class DBConfig {
	//-- 1.配置信息
	@Value("${jdbc.driverClass}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String uesrname;
	@Value("${jdbc.password}")
	private String password;

	//-- 2.DataSource Bean
	@Bean(name = "dataSource")
	public DataSource createDataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(uesrname);
		ds.setPassword(password);
		return ds;
	}
	
	//-- 3.jdbcTemplate
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate createJdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	//  4.配置事务管理器
	@Bean
	public PlatformTransactionManager createTransactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
	
}
