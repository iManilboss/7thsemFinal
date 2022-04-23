package com.ars.RealState.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class RmsSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin123"));
		return encoder;
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
	.antMatchers("/admin/**").hasRole("ADMIN")
	.antMatchers("/user/**").hasRole("USER")
	.antMatchers("/agent/**").hasRole("AGENT")
	.antMatchers("/").permitAll()
	.and()
	.formLogin().loginPage("/login")
	.loginProcessingUrl("/login")
	.defaultSuccessUrl("/home")
	.failureUrl("/login?error=true")
	.successHandler(new CustomSuccessHandler())
	.usernameParameter("username")
	.passwordParameter("password")
	.and()
	.logout()
	.logoutUrl("/logout")
	.logoutSuccessUrl("/login?logout=true")
	.invalidateHttpSession(true)
	.and()
	.csrf().disable(); //cross site request forgery
}
	
	
//	@Override
//		public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("admin")
//		.password("$2a$10$E7w.BeZW2jTFQ4PqAUo7yOfDxE8fQg5A61GvEv2i8Sn5F5oe5.oWm")
//		.roles("ADMIN");
//		
//	}

	
	@Override
public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.passwordEncoder(passwordEncoder)
		.dataSource(datasource)
		.usersByUsernameQuery("select username,password,active from user_detail where  username=?")
		.authoritiesByUsernameQuery("select ud.username,ur.role from user_detail ud, user_role as ur"
				+ " where ud.ud_id  =ur.ud_id  and username=?");
		
	}
	
	
	
	
	
	
}
