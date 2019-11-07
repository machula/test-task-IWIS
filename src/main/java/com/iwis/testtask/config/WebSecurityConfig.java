/*

package com.iwis.testtask.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.iwis.testtask.db.entity.User;
import com.iwis.testtask.db.repository.UserRepoImpl;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().mvcMatchers("/", "/login**", "/js/**").permitAll().anyRequest().authenticated().and().csrf().disable();
	}
	
	@Bean
	public PrincipalExtractor principalExtractor(UserRepoImpl userRepo) {
		return map -> {
			return new User();
		};
	}
}
*/
