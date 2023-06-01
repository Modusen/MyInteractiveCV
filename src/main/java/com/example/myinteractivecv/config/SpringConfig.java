package com.example.myinteractivecv.config;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@ComponentScan("com.example.myinteractivecv")
@EnableWebMvc
@AllArgsConstructor
public class SpringConfig implements WebMvcConfigurer {
    private final ApplicationContext applicationContext;

    @Bean
    public SpringResourceTemplateResolver templateResolver() {

        final String TEMPLATE_PREFIX = "/WEB-INF/views/";
        final String TEMPLATE_SUFFIX = ".html";

        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix(TEMPLATE_PREFIX);
        templateResolver.setSuffix(TEMPLATE_SUFFIX);
        return templateResolver;
    }

    //Templates - Более современное представление JSPs.
    @Bean()
    public SpringTemplateEngine templateEngine() {

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        // ExpressionLanguage синтаксис, позволяющий работать с параметрами внутри тегов (передача параметров на темплейты или объекты для отображения)
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }
}
