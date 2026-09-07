package com.corebank.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/*")
public class LoggingFilter implements Filter {

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
     
       System.out.println("Filter initalized");
   }



   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        System.out.println("[Filter] Request entered , about to hit the application code");

       chain.doFilter(request, response);

       System.out.println("[Filter] Response returned from application code");
   }

   @Override
   public void destroy() {
       
       System.out.println("Filter destroyed");
   }
}
