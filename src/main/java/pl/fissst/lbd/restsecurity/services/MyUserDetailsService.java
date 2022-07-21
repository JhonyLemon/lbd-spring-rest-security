package pl.fissst.lbd.restsecurity.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static pl.fissst.lbd.restsecurity.security.SecurityRoles.*;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final Map<String, UserDetails> users;;

    public MyUserDetailsService() {
        users = new HashMap<>() {{
            put("user", User.builder()
                    .username("user")
                    .password("user")
                    .roles(USER.name())
                    .build());
            put("admin", User.builder()
                    .username("admin")
                    .password("admin")
                    .roles(ADMIN.name())
                    .build());
        }};
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!users.containsKey(username))
            throw new UsernameNotFoundException("Username not found");
        return users.get(username);
    }
}
