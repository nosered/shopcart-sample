package br.eti.esabreu.shopcartsample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.eti.esabreu.shopcartsample.service.UserService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
		.ignoring()
		.antMatchers("/ws/**")
		.antMatchers("/home/**")
		.antMatchers("/js/**");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		auth.inMemoryAuthentication()
		.withUser("one").password("{noop}1234").roles("CUSTOMER").and().passwordEncoder(passwordEncoder())
		.withUser("two").password("{noop}1234").roles("CUSTOMER").and().passwordEncoder(passwordEncoder())
		.withUser("three").password("{noop}1234").roles("CUSTOMER").and().passwordEncoder(passwordEncoder());
		*/
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/", true).failureUrl("/login?error").permitAll()
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll();
	}
}