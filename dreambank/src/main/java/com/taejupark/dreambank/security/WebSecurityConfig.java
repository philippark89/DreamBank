package com.taejupark.dreambank.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
                .mvcMatchers("/").permitAll()
//                .mvcMatchers(HttpMethod.POST,"/api/v1/customers").permitAll()
                .mvcMatchers("/api/v1/customers").permitAll()
                .mvcMatchers("/about").permitAll()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/customers").permitAll()
                .mvcMatchers("/error").permitAll()
                .and().authorizeRequests()
//                .mvcMatchers("/customers").permitAll()
//                .mvcMatchers("/deleteEmployee/**").hasAnyRole("SUPERADMIN")
//                .mvcMatchers("/showFormForUpdate/**").hasAnyRole("ADMIN", "SUPERADMIN")
//                .mvcMatchers("/showEmployeeForm/**").hasAnyRole("ADMIN", "SUPERADMIN")
//                .mvcMatchers("/saveEmployee/**").hasAnyRole("ADMIN", "SUPERADMIN")
//                .mvcMatchers("/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .anyRequest().authenticated()
                .and().cors().and().csrf().disable()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        // @formatter:on
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder.encode("user")).roles("USER").and()
                .withUser("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN").and()
                .withUser("superadmin").password(passwordEncoder.encode("superadmin")).roles("USER", "ADMIN", "SUPERADMIN");

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/image/**");
    }
}
