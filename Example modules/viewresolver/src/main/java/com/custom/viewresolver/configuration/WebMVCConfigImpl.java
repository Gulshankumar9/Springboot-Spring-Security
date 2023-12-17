package com.custom.viewresolver.configuration;

import com.custom.viewresolver.interceptor.InterceptorHandler;
import com.custom.viewresolver.views.FreeMarkerViewImpl;
import com.custom.viewresolver.views.ViewResolverImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@ComponentScan(basePackages = "com.custom.viewresolver")
public class WebMVCConfigImpl implements WebMvcConfigurer {

    /*@Autowired
    public InterceptorHandler interceptorhandler;*/

    public InterceptorHandler interceptorHandler() {

        return new InterceptorHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(interceptorHandler()).addPathPatterns("/forwardFrom", "/redirectFrom");
    }

    @Bean
    public ViewResolver viewResolver() {

        ViewResolverImpl viewresolverimpl = new ViewResolverImpl();
        viewresolverimpl.setViewClass(AbstractUrlBasedView.class);
        viewresolverimpl.setViewNames("ftl", "jsp", "redirect", "forward");
        viewresolverimpl.setCache(true);
        viewresolverimpl.setOrder(0);

        return viewresolverimpl;

    }

    //custom freemarker resolver
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {

        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPaths("/WEB-INF/ftl/");
        configurer.setDefaultEncoding("UTF-8");
        return configurer;

    }

    @Bean
    public FreeMarkerViewResolver customFreemarkerViewResolver() {

        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setViewClass(FreeMarkerViewImpl.class);
        resolver.setCache(true);

        resolver.setSuffix(".ftl");
        resolver.setOrder(1);

        return resolver;
    }

}