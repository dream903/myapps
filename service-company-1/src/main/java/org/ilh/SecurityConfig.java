package org.ilh;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   @Override
   protected void configure(HttpSecurity http) throws Exception {
         http
            .csrf()
            .disable()
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
   }
//   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//     auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN","USER");
//     auth.inMemoryAuthentication().withUser("user1").password("{noop}1234").roles("USER");

 }