package fr.dta.mediatic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@ComponentScan("fr.dta.mediatic")
@PropertySource("classpath:application.properties")
public class MediaticApplication extends WebMvcConfigurerAdapter {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry)
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("ui/app/");
		viewResolver.setSuffix(".html");
		viewResolver.setExposeContextBeansAsAttributes(true);
		registry.viewResolver(viewResolver);
	}
	
    public static void main1(String[] args) {
        System.out.println("coucou");
    }
}
