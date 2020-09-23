package com.pluralsight.security.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
			.authorizeRequests()
				.mvcMatchers(HttpMethod.GET,"/","/index.html","/portfolio/**").permitAll()
				.anyRequest().authenticated()
			.and()
		.httpBasic()
			.authenticationEntryPoint(new AuthenticationEntryPoint() {
				
				@Override
				public void commence(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException authException) throws IOException, ServletException {
					response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
				}
			})
		.and()
		.logout()
			.logoutUrl("/api/logout")
			.logoutSuccessUrl("/");
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("victoria").password("{noop}password").roles("ADMIN")
									 .and().withUser("dave").password("{noop}password").roles("USER");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/webjars/**","/js/**");
	}
	
	protected void configurez(HttpSecurity http) throws Exception {
		http
			.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
			.authorizeRequests()
				.mvcMatchers(HttpMethod.GET,"/","/index.html","/portfolio/**").permitAll()
				.anyRequest().authenticated()
			.and()
		.httpBasic()
		 .authenticationEntryPoint(new AuthenticationEntryPoint(){
             @Override
             public void commence(HttpServletRequest request, HttpServletResponse response,
                 AuthenticationException authException) throws IOException, ServletException {
                     response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
             }
         })
		.and()
		.logout()
			.logoutUrl("/api/logout")
			.logoutSuccessUrl("/");
	}
	
}