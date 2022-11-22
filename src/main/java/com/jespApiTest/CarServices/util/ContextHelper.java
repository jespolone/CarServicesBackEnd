package com.jespApiTest.CarServices.util;

import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;


public class ContextHelper {

    public static ExceptionHandlerExceptionResolver withExceptionControllerAdvice(){
        final ExceptionHandlerExceptionResolver exceptionHanlderExceptionResolver = new ExceptionHandlerExceptionResolver();
        exceptionHanlderExceptionResolver.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        final StaticApplicationContext staticApplicationContext = new StaticApplicationContext();
        staticApplicationContext.registerBeanDefinition("advice", new RootBeanDefinition(GlobalExceptionHandler.class));

        exceptionHanlderExceptionResolver.setApplicationContext(staticApplicationContext);
        exceptionHanlderExceptionResolver.afterPropertiesSet();
        return exceptionHanlderExceptionResolver;
    }
}
