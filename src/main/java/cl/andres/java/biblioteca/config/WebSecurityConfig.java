package cl.andres.java.biblioteca.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import cl.andres.java.biblioteca.service.ServicioDetallesUsuario;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	ServicioDetallesUsuario servicioDetallesUsuario;
	
	@Autowired
	PasswordEncoder passEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(servicioDetallesUsuario)
			.passwordEncoder(passEncoder)
		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(authorize -> authorize
					.mvcMatchers("/","/ingreso","/generaradmin").permitAll()
					.mvcMatchers("/admin/index","/admin/nuevolibro").hasAuthority("ADMIN")
					.anyRequest().authenticated()
			)
			.formLogin(form -> form
					.loginPage("/ingreso")
					.defaultSuccessUrl("/",true)
					.permitAll()
			)
			.logout(logout -> logout
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
			)	
		;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
			.mvcMatchers("/img/**", "/css/**","/js/**")
		;
	}

	
	
	
}
