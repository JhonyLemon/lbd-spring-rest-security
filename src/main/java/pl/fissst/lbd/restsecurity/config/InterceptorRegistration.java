package pl.fissst.lbd.restsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.fissst.lbd.restsecurity.interceptors.AuthorizeInterceptor;

@EnableWebMvc
@Configuration
public class InterceptorRegistration implements WebMvcConfigurer {

    AuthorizeInterceptor interceptor;

    public InterceptorRegistration(AuthorizeInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}
