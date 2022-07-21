package pl.fissst.lbd.restsecurity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.fissst.lbd.restsecurity.filters.JwtAuthenticationFilter;
import pl.fissst.lbd.restsecurity.filters.JwtAuthorizationFilter;
import pl.fissst.lbd.restsecurity.jwt.JwtConfig;
import pl.fissst.lbd.restsecurity.services.MyUserDetailsService;

import javax.crypto.SecretKey;

import static pl.fissst.lbd.restsecurity.security.SecurityPermissions.*;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService userDetailsService;
    private final PasswordEncoder encoder;

    private final SecretKey secretKey;

    private final JwtConfig config;



    public SecurityConfig(MyUserDetailsService userDetailsService, PasswordEncoder encoder, SecretKey secretKey, JwtConfig config) {
        this.userDetailsService = userDetailsService;
        this.encoder = encoder;
        this.secretKey = secretKey;
        this.config = config;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), config, secretKey))
                .addFilterAfter(new JwtAuthorizationFilter(config,secretKey),JwtAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/user/**").hasAnyAuthority(ADMIN.name(),USER_READ.name())
                .antMatchers(HttpMethod.PUT, "/api/user/**").hasAnyAuthority(ADMIN.name(),USER_EDIT.name())
                .antMatchers(HttpMethod.GET, "/api/admin/**").hasAnyAuthority(ADMIN.name())
                .antMatchers(HttpMethod.POST, "/api/admin/**").hasAnyAuthority(ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/api/admin/**").hasAnyAuthority(ADMIN.name())
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.eraseCredentials(false).userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

}
