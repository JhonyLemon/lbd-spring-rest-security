package pl.fissst.lbd.restsecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;


import org.junit.jupiter.api.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.fissst.lbd.restsecurity.dto.Teacher;
import pl.fissst.lbd.restsecurity.dto.enums.Subject;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TeacherControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(2)
    void addTeacher() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/teacher")
                        .header("role","TEACHER_ROLE")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                new ObjectMapper().writeValueAsString(
                                        new Teacher(null,"dd","dd", Subject.LAW)
                                )
                        ))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.subject", Is.is(Subject.LAW.toString())));

    }
    @Test
    @Order(1)
    void deleteTeacher() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/teacher/3")
                        .header("role","TEACHER_ROLE"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Is.is(true)));
    }
    @Test
    void getTeacher() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/teacher/1")
                        .header("role","TEACHER_ROLE"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName", Is.is("Kuba")));
    }
    @Test
    void getTeacherClass() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/teacher/1/class")
                        .header("role","TEACHER_ROLE"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.[1].firstName", Is.is("Michael")));

    }
    @Test
    void deleteStudentFromClassByTeacherId() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/teacher/1/class/remove/9")
                        .header("role","TEACHER_ROLE"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Is.is(true)));
    }
}
