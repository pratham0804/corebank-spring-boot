package com.corebank.config;

import com.corebank.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration 
public class WebConfig implements WebMvcConfigurer{
    
    private final LoggingInterceptor loggingInterceptor;

    public WebConfig(LoggingInterceptor loggingInterceptor){
        this.loggingInterceptor = loggingInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
        // @Autowired //, also where do we use autowired
        // private final LoggingInterceptor loggingInterceptor; // jab koi method me dependency inject karna hai ,we use property. but 
        // Auto wired shows error, field injection is not allowed in most cases, idk the reason

        registry.addInterceptor(loggingInterceptor);
    }
}
