package pl.fissst.lbd.restsecurity.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.fissst.lbd.restsecurity.filters.SetDecimalFilter;
import pl.fissst.lbd.restsecurity.filters.TimestampFilter;

@Configuration
public class FilterRegistration {

    @Bean
    public FilterRegistrationBean<SetDecimalFilter> setDecimalFilter(){
        FilterRegistrationBean<SetDecimalFilter> registration
                = new FilterRegistrationBean<>();

        registration.setFilter(new SetDecimalFilter());
        registration.addUrlPatterns("/api/decimal/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean<TimestampFilter> timestampFilter(){
        FilterRegistrationBean<TimestampFilter> registration
                = new FilterRegistrationBean<>();

        registration.setFilter(new TimestampFilter());
        registration.addUrlPatterns("/api/number");
        return registration;
    }

}
