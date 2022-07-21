package pl.fissst.lbd.restsecurity;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "tytuł",description = "opis"))
public class RestSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestSecurityApplication.class, args);
    }

}
