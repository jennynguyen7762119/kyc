/**
 * 
 */
package com.oto.kyc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import com.oto.kyc.model.util.CurrentUserGetter;
import com.oto.kyc.web.util.ContextHolderCurrentUserGetterStrategry;

/**
 * @author thuyntp
 *
 */
@Configuration
@EnableWebMvc
public class SpringMvcConfigurer extends WebMvcConfigurerAdapter{

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**/*").addResourceLocations("/WEB-INF/assets/");
    }
	
	/**
     * ServletContextTemplateResolver initialization.
     * 
     * @return {@link ServletContextTemplateResolver} instance.
     */
    @Bean
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCacheable(false);
        return resolver;
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    	CurrentUserGetter.getInstance().insertCurrentUserGetterStrategy(new ContextHolderCurrentUserGetterStrategry());
    }
}
