package br.com.capgemini.desafio.configuracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SegurancaConfiguracao extends WebSecurityConfigurerAdapter {

	@Autowired
	private RestPontoEntradaAutenticacao restPontoEntradaAutenticacao;

	@Autowired
	private SucessoAutenticacaoHandler sucessoAutenticacaoHandler;

	@Autowired
	private DataSource datasource;

	@Autowired
	private ServicoDetalheUsuario servicoDetalheUsuario;

	@Autowired
	private RestPontoEntradaAutenticacao basicAuthenticationPoint;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.authentication.builders.AuthenticationManagerBuilder) Configura
	 * fonte de autenticação de usuários
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(servicoDetalheUsuario).and().jdbcAuthentication().dataSource(datasource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().exceptionHandling().authenticationEntryPoint(restPontoEntradaAutenticacao).and()
				.authorizeRequests().antMatchers("/api").authenticated().and().formLogin()
				.successHandler(sucessoAutenticacaoHandler).failureHandler(new SimpleUrlAuthenticationFailureHandler())
				.and().logout();
		http.httpBasic().authenticationEntryPoint(basicAuthenticationPoint);
	}

	@Bean
	public PasswordEncoder getBCryptEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(servicoDetalheUsuario);
		authenticationProvider.setPasswordEncoder(getBCryptEncoder());
		return authenticationProvider;
	}

}
