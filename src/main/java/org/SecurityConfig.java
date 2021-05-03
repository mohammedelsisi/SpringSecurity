package org;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("jets")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("jets")).roles("ADMIN")
                .and()
                .withUser("manager").password(passwordEncoder().encode("jets")).roles("MANAGER");


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/manager/**").hasAuthority("ROLE_MANAGER")
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER")
        /*     .antMatchers("/**").permitAll()   default      */
                .and()
//                 .httpBasic();
                .formLogin()
                    .loginPage("/login")
                  //  .loginProcessingUrl("/loginProcess")
                    .usernameParameter("userName")
                    .passwordParameter("password")
                    //.permitAll()
                .and()
                .logout()
                    .logoutUrl("/logout")    // links must start with forward slash
                    .logoutSuccessUrl("/login")
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                .and()
                .csrf()
                    .disable()    // disable to be able to log out with a GET Request
                .exceptionHandling()
                     .accessDeniedPage("/error")
                .and()
                .rememberMe()
                    .tokenValiditySeconds(60*60*24*14)
                    .key("key")
//                    .rememberMeParameter("remember-me");    /* default remember me value   */
                .and()
                .sessionManagement()
                    .maximumSessions(1);    // HttpSessionEventPublisher is needed to listen of the session destruction

    }
}
