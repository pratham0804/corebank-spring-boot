package com.corebank.interceptor;

import java.time.Duration;
import java.time.Instant;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component 
public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                
        System.out.println("[Interceptor] Request started:/ "+ request.getRequestURI());
        request.setAttribute("startTime", Instant.now());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        
            System.out.println("[Interceptor] Execution of controller is finished and response is getting processed");
       
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {
         Instant st = (Instant) request.getAttribute("startTime");

         Instant curr = Instant.now();
         Duration requestRoundTripTime = Duration.between(st, curr);

         System.out.println("[Interceptor] Request completed | Time : " + requestRoundTripTime);

    }

    
}
