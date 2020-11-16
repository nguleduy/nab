package com.example.joseph.productservice.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.ConcurrentSessionFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.addFilterAfter(new CustomAuthenticationFilter(), ConcurrentSessionFilter.class);
    http.authorizeRequests()
            .antMatchers("/products").authenticated()
            .antMatchers("/products" + "/*").authenticated()
            .anyRequest().permitAll();
    http.csrf().disable();
  }

}
