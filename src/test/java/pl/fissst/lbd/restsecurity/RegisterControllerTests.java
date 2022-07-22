package pl.fissst.lbd.restsecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.fissst.lbd.restsecurity.dtos.AuthorityDto;
import pl.fissst.lbd.restsecurity.dtos.UserDto;
import pl.fissst.lbd.restsecurity.security.Permissions;

import java.util.Arrays;
import java.util.HashSet;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerTests {

    @Autowired
    private MockMvc mockMvc;

    public void CreateUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/register").content(new ObjectMapper().writeValueAsString(                new UserDto(
                        null,
                        "kek",
                        "kek",
                        new HashSet<>(Arrays.asList(
                                new AuthorityDto(null, Permissions.ACCESS_ALL)
                        )),
                        true,
                        true,
                        true,
                        true
                ))))
                .andExpect(status().isOk());
    }

}
