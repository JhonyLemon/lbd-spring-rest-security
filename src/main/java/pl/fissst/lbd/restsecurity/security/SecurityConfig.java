package pl.fissst.lbd.restsecurity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.fissst.lbd.restsecurity.services.MyUserDetailsService;

import static pl.fissst.lbd.restsecurity.security.Permissions.*;

@EnableWebMvc
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(MyUserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(HttpMethod.PUT,"/api/decimal/**")
                .hasAnyAuthority(DECIMAL_WRITE.name(), ACCESS_ALL.name())
                .antMatchers(HttpMethod.PUT,"/api/multiplier/**")
                .hasAnyAuthority(MULTIPLIER_WRITE.name(), ACCESS_ALL.name())
                .antMatchers("/register/**")
                .permitAll()
                .antMatchers("/api/user/**")
                .hasAnyAuthority(ACCESS_ALL.name())
                .and()
                .httpBasic()
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
