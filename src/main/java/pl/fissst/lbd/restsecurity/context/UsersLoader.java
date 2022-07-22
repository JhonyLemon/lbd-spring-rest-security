package pl.fissst.lbd.restsecurity.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import pl.fissst.lbd.restsecurity.dtos.AuthorityDto;
import pl.fissst.lbd.restsecurity.dtos.UserDto;
import pl.fissst.lbd.restsecurity.security.Permissions;
import pl.fissst.lbd.restsecurity.services.RegisterService;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class UsersLoader implements ApplicationContextAware {

    @Autowired
    RegisterService service;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        service.CreateUser(
                new UserDto(
                        null,
                        "admin",
                        "admin",
                        new HashSet<>(Arrays.asList(
                                new AuthorityDto(null, Permissions.ACCESS_ALL)
                        )),
                        true,
                        true,
                        true,
                        true
                        )
        );
        service.CreateUser(
                new UserDto(
                        null,
                        "decimal",
                        "decimal",
                        new HashSet<>(Arrays.asList(
                                new AuthorityDto(null, Permissions.DECIMAL_READ),
                                new AuthorityDto(null,Permissions.DECIMAL_WRITE)
                        )),
                        true,
                        true,
                        true,
                        true
                )
        );
        service.CreateUser(
                new UserDto(
                        null,
                        "multi",
                        "multi",
                        new HashSet<>(Arrays.asList(
                                new AuthorityDto(null, Permissions.MULTIPLIER_WRITE),
                                new AuthorityDto(null, Permissions.MULTIPLIER_READ)
                        )),
                        true,
                        true,
                        true,
                        true
                )
        );
    }
}
