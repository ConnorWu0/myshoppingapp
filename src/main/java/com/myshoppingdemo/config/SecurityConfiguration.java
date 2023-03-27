package com.myshoppingdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.myshoppingdemo.service.UserService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	// add a reference to our user service
	@Autowired
	private UserService userService;

	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Autowired
	public SecurityConfiguration(UserService userService) {
		this.userService = userService;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> {
							try {
								authz
										.antMatchers("/account/**").hasRole("CUSTOMER")
										.antMatchers("/systems/**").hasRole("ADMIN")
										.antMatchers("/addItem/**").hasRole("ADMIN")
										.antMatchers("/").permitAll()
										.and()
										.formLogin()
										.loginPage("/showMyLoginPage")
										.loginProcessingUrl("/authenticateTheUser")
										.successHandler(customAuthenticationSuccessHandler)
										.permitAll()
										.and()
										.logout().permitAll()
										.and()
										.exceptionHandling().accessDeniedPage("/access-denied")
										.and()
										.csrf().disable();
							} catch (Exception e) {
								throw new RuntimeException(e);
							}
						}
				);
		return http.build();
	}


	//beans
	//bcrypt bean definition
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	//authenticationProvider bean definition
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService); //set the custom user details service
		auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
		return auth;
	}

}






