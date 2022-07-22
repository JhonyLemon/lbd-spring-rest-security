package pl.fissst.lbd.restsecurity.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.fissst.lbd.restsecurity.dtos.UserDto;
import pl.fissst.lbd.restsecurity.entities.User;
import pl.fissst.lbd.restsecurity.mappers.AuthMapper;
import pl.fissst.lbd.restsecurity.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    private final AuthMapper mapper;

    public UserService(UserRepository repository, PasswordEncoder encoder, AuthMapper mapper) {
        this.repository = repository;
        this.encoder = encoder;
        this.mapper = mapper;
    }

    public UserDto getUser(String username){
        Optional<User> user=repository.findUserByUsername(username);
        if(!user.isPresent())
            throw new NoSuchElementException("User not found");
        UserDto u = mapper.mapUserToUserDto(user.get());
        return u;
    }

    public void deleteUser(String username){
        Optional<User> user=repository.findUserByUsername(username);
        if(!user.isPresent())
            throw new NoSuchElementException("User not found");
        repository.delete(user.get());
    }
    @Transactional
    public void updatePassword(String username,String password){
        Optional<User> user=repository.findUserByUsername(username);
        if(!user.isPresent())
            throw new NoSuchElementException("User not found");
        user.get().setPassword(encoder.encode(password));
        mapper.mapUserToUserDto(user.get());
    }

}
