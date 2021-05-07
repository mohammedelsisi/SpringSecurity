package org;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        dataSource.setUsername("m77md");
        dataSource.setPassword("1234");


        return dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("jets")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("jets")).roles("ADMIN")
//                .and()
//                .withUser("manager").password(passwordEncoder().encode("jets")).roles("MANAGER");

        auth.jdbcAuthentication()
                .dataSource(dataSource())
                .passwordEncoder(passwordEncoder())  // optional  but password has to be hashed in the DB
                .usersByUsernameQuery(
                             "SELECT username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery(
                        "SELECT u.username, a.authority " +
                                "FROM user_authorities a, users u " +
                                "WHERE u.username = ? " +
                                "AND u.id = a.user_id"
                );

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
                      .tokenValiditySeconds(60 * 60 * 24 * 14)
                      .key("key")
//                    .rememberMeParameter("remember-me");    /* default remember me value   */
                .and()
                .sessionManagement()
                     .sessionFixation()
                     .changeSessionId()           //To protect against session fixation attack the default is migrate session
                     .maximumSessions(1);        // HttpSessionEventPublisher is needed to listen of the session destruction
                                                // a second login will cause the first to be invalidated.
    }
}
