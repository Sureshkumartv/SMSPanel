package com.pyxis.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
// http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
// Switch off the Spring Boot security configuration
// @EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	private AuthSuccessHandler authSuccessHandler;
        
        
    @Value("${server.context.path}")
    String contextPath;
        
	

	// roles admin allow to access /admin/**
	// roles user allow to access /user/**
	// custom 403 access denied handler
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http.csrf().disable()
//        .authorizeRequests()
//            .antMatchers(
//            		  "/about", "/loginpages/**", "/mainpages/**", "/login*").permitAll()
//            .anyRequest().authenticated();
		
		http.csrf().disable();
//    	http
//        .authorizeRequests()
//            .antMatchers(
//            		"/about",
//            		"/loginpages/**",
//            		"/mainpages/**",
//            		"/login**"
//            		).permitAll()
//            .anyRequest().authenticated();
		
		http
        .authorizeRequests()
            .antMatchers("/", 	"/templates/**","/loginpages/**").permitAll().anyRequest().fullyAuthenticated();
    	
        http
            .formLogin().successHandler(authSuccessHandler)
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
//		http.csrf().disable().authorizeRequests().
//			antMatchers("/", "/home", "/about", "/loginpages/**", "/mainpages/**", "/login*").permitAll()
//			.antMatchers("/admin/**").hasAnyRole("ADMIN")
////			.antMatchers("/user/**").hasAnyRole("USER")
//			.anyRequest()
//			.authenticated().and()
//			.formLogin().successHandler(authSuccessHandler)
//			.loginPage("/login")
//			.permitAll()
//			.and()
//			.logout()
//			.permitAll()
//			.and().exceptionHandling().accessDeniedHandler(accessDeniedHandler)
			;
	}
	
//	 @Autowired
//	 public void configureGlobal(AuthenticationManagerBuilder auth) throws
//	 Exception {
//	
//	 auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin")
//	 .password("password").roles("ADMIN");
//	 }

	/*
	 * //Spring Boot configured this already.
	 * 
	 * @Override public void configure(WebSecurity web) throws Exception { web
	 * .ignoring() .antMatchers("/resources/**", "/static/**", "/css/**",
	 * "/js/**", "/images/**"); }
	 */

	@Resource
	private UserDetailsService userService;
        
      

	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		authManagerBuilder.userDetailsService(userService);
	}
        
       

}
