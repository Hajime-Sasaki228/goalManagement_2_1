package com.example.demo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.auth.DatabaseUserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DatabaseUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 静的ファイルに対するアクセスはセキュリティ設定を無視する
		web.ignoring().antMatchers("/css/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// 認証無しでアクセスできるURL
				.antMatchers("/", "/signup", "/login").permitAll()
				// 上記以外は認証が必要
				.anyRequest().authenticated();

		http.formLogin().loginPage("/login")
				// どのリクエストパラメータで認証を行うか
				.usernameParameter("email").passwordParameter("password").permitAll()
				 .defaultSuccessUrl("/home")
				.failureForwardUrl("/loginError")
				// TODO: 認証成功時に呼ばれるハンドラクラス
				// .successHandler(successHandler)
				// TODO: 認証失敗時に呼ばれるハンドラクラス
				// .failureHandler(failureHandler)
				.and()
				// "/logout"にPOSTメソッドでリクエストを投げるとSpring securityがログアウト処理を実行する
				.logout().logoutSuccessUrl("/logout").permitAll()
				// セッションを破棄
				.invalidateHttpSession(true).deleteCookies("JSESSIONID");
	}

	@Bean
	public PasswordEncoder passwordEncorder() {
		return new BCryptPasswordEncoder();
	}
}
