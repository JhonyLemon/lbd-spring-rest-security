package pl.fissst.lbd.restsecurity;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.*;
import pl.fissst.lbd.restsecurity.dtos.UserDto;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControlerTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser(authorities = {
            "ACCESS_ALL"
    })
    public void GetUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/decimal"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(authorities = {
            "ACCESS_ALL"
    })
    public void DeleteUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/user/multi"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(authorities = {
            "ACCESS_ALL"
    })
    public void UpdatePassword() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/decimal")
                        .param("password","password"))
                .andExpect(status().isOk());
    }
}
