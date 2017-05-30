package com.expense.master.filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
@Override
public void addCorsMappings(CorsRegistry registry) {
registry.addMapping("/**")
.allowedOrigins("*")
.allowedMethods("PUT", "DELETE" , "POST" , "OPTIONS" )
.allowedHeaders("Origin", "X-Requested-With", "Content-Type, Accept" , "api_key", "Authorization")
//.allowedHeaders("Content-Type", "api_key", "Authorization")
.exposedHeaders("header1", "header2")
.allowCredentials(false).maxAge(3600);

}
}