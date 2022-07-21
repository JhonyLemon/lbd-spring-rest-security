package pl.fissst.lbd.restsecurity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.fissst.lbd.restsecurity.services.MyUserDetailsService;

import static pl.fissst.lbd.restsecurity.security.SecurityRoles.*;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService userDetailsService;
    private final PasswordEncoder encoder;

    public SecurityConfig(MyUserDetailsService userDetailsService, PasswordEncoder encoder) {
        this.userDetailsService = userDetailsService;
        this.encoder = encoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/user/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/user/**").hasAnyRole(ADMIN.name(),USER.name())
                .antMatchers(HttpMethod.GET, "/api/admin/**").hasAnyRole(ADMIN.name(),USER.name())
                .antMatchers(HttpMethod.POST, "/api/admin/**").hasAnyRole(ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/api/admin/**").hasAnyRole(ADMIN.name())
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.eraseCredentials(false).userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

}
