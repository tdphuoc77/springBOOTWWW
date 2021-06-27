package com.onthi.bai17client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser("user")
		.password(encoder.encode("user")).roles("USER")
		.and()
		.withUser("admin")
		.password(encoder.encode("admin")).roles("ADMIN","USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		.authorizeRequests()
		.antMatchers("/tacpham/add").hasAnyRole("USER","ADMIN")
		.antMatchers("/tacpham/delete/**").hasRole("ADMIN")
		.antMatchers("/tacpham/update/**").hasRole("ADMIN")
		.anyRequest().permitAll()
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error");
		
//		http.authorizeRequests() .anyRequest() .authenticated()
//        .and().csrf() .disable()
//        .formLogin()  .permitAll().and() .logout() .permitAll();
	}
}
