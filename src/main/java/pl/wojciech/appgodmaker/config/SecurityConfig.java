package pl.wojciech.appgodmaker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.wojciech.appgodmaker.user.SpringDataUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/users/details").authenticated() //można dać więcej role'i
                .antMatchers("/leagues/**").authenticated()
                .antMatchers("/rounds/**").authenticated()
                .antMatchers("/matches/**").authenticated()
                .antMatchers("/dashboard").authenticated()
                .antMatchers("/bets/**").authenticated()
                .anyRequest().permitAll() //nadmiarowe ale ogólnie jeśli adres nie został opisany to daje mu globalny dostęp
                .and().formLogin()
                .loginPage("/login").defaultSuccessUrl("/dashboard").failureUrl("/login?error=fail")
                .and().logout().logoutSuccessUrl("/")
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/403");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }
}
