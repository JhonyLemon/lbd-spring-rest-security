package pl.fissst.lbd.restsecurity.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.fissst.lbd.restsecurity.filters.AuthorizationStudentFilter;

@Configuration
public class FilterRegistration {

    @Bean
    public FilterRegistrationBean<AuthorizationStudentFilter> authorizationStudentFilter(){
        FilterRegistrationBean<AuthorizationStudentFilter> registration
                = new FilterRegistrationBean<>();

        registration.setFilter(new AuthorizationStudentFilter());
        registration.addUrlPatterns("/api/student/*");
        registration.setOrder(2);

        return registration;
    }

}
