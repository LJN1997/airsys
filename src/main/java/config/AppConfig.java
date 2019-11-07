package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * 应用配置（spring）
 * 它相当于XML的替代者
 * @author Administrator
 */
@Configuration
@ComponentScan({"dao","service","util","controller"})
@Import(DBConfig.class)
/*@EnableWebMvc*/
public class AppConfig extends WebMvcConfigurationSupport{
	/**
	 * jsp的解析器
	 * 这个bean的作用是告诉spring mvc你写的jsp文件的位置
	 * @return
	 */
	@Bean
	public UrlBasedViewResolver setUpViewResolver(){
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/");//--位置
		resolver.setSuffix(".jsp");//--jsp文件的后缀，你在写页面的时候就省略掉后缀
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
		super.addResourceHandlers(registry);
	}
}
