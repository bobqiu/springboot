package com.qiu.dmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.MultipartConfigElement;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/12.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ImportResource({"classpath:dubbo.xml", "classpath:application-context.xml"})
@ConfigurationProperties(prefix = "data")
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        /*YamlPropertySourceLoader yamlPropertySourceLoader = new YamlPropertySourceLoader();
        yamlPropertySourceLoader.load("app.yml",new resou)*/

        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        System.out.println("this beans  from spring boot");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("128000KB");
        factory.setMaxRequestSize("2560000KB");
        return factory.createMultipartConfig();
    }
}
