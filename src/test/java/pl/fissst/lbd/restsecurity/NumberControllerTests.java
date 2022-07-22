package pl.fissst.lbd.restsecurity;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static pl.fissst.lbd.restsecurity.security.Permissions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class NumberControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(authorities = {
            "ACCESS_ALL"
    })
    public void getCalculatedValues() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/number"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valueTwo", Is.isA(Double.class)))
                .andExpect(jsonPath("$.valueOne", Is.isA(Double.class)));
    }


}
