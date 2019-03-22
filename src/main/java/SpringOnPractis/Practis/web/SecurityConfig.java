package SpringOnPractis.Practis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import SpringOnPractis.Practis.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity Http) throws Exception{
		Http
		.authorizeRequests()
		.antMatchers("/readme.txt", "/css/*").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll();
	}
	@Autowired
	private UserService userservice;
	
	@Bean
	public PasswordEncoder bcryptpasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{

	//	auth.inMemoryAuthentication().withUser("123").password("{noop}123").roles("USER");
		
		auth.userDetailsService(userservice).passwordEncoder(bcryptpasswordEncoder());
		
	}
}
