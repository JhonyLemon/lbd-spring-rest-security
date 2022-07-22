package pl.fissst.lbd.restsecurity;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static pl.fissst.lbd.restsecurity.security.Permissions.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MultiplierControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    @WithMockUser(authorities = {
            "ACCESS_ALL"
    })
    public void setMultiplier() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/multiplier/1"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    @WithMockUser(authorities = {
            "ACCESS_ALL"
    })
    public void GetMultiplier() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/multiplier"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Is.isA(Integer.class)))
                .andExpect(jsonPath("$", Is.is(1)));
    }

}
