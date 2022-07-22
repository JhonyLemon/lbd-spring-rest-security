package pl.fissst.lbd.restsecurity.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.fissst.lbd.restsecurity.dtos.UserDto;
import pl.fissst.lbd.restsecurity.entities.User;
import pl.fissst.lbd.restsecurity.mappers.AuthMapper;
import pl.fissst.lbd.restsecurity.repositories.AuthoritiesRepository;
import pl.fissst.lbd.restsecurity.repositories.UserRepository;

@Service
public class RegisterService {

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    private final AuthoritiesRepository authoritiesRepository;
    private final AuthMapper mapper;


    public RegisterService(PasswordEncoder encoder, UserRepository userRepository, AuthoritiesRepository authoritiesRepository, AuthMapper mapper) {
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.mapper = mapper;
    }
    public UserDto CreateUser(UserDto userDto){
        User user = mapper.mapUserDtoToUser(userDto);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.getAuthorities().forEach(x-> x.setUser(user));
        userRepository.save(user);
        authoritiesRepository.saveAll(user.getAuthorities());
        return mapper.mapUserToUserDto(user);
    }

}
