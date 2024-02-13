package com.ecommerce.ecommerce.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiuration implements WebMvcConfigurer {

    //Con el metodo ResourceHandlerRegistry y el addResourceHandler enviamos que spring busque
    //la carpeta /images y agarre las imagenes de ahi y con addResourceLocations le decimos la locacion
    //de donde se va guardar las imagenes
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:images/");
    }
}
