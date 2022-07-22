package pl.fissst.lbd.restsecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fissst.lbd.restsecurity.dtos.UserDto;
import pl.fissst.lbd.restsecurity.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{username}")
    public ResponseEntity<UserDto> GetUser(@PathVariable("username") String username){
        return ResponseEntity
                .ok()
                .body(userService.getUser(username));
    }
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> DeleteUser(@PathVariable("username") String username){
        userService.deleteUser(username);
        return ResponseEntity
                .ok()
                .build();
    }

    @PutMapping("/{username}")
    public ResponseEntity<Void> UpdatePassword(@PathVariable("username") String username,@RequestBody String password){
        userService.updatePassword(username,password);
        return ResponseEntity
                .ok()
                .build();
    }

}
