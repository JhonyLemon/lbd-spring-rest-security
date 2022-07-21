package pl.fissst.lbd.restsecurity.controllers;

import org.springframework.web.bind.annotation.*;
import pl.fissst.lbd.restsecurity.dto.Student;
import pl.fissst.lbd.restsecurity.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getAllStudent(){

        return studentService.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.insertStudent(student);
    }

    @PutMapping("/{id}")
    public Student editStudent(
            @PathVariable("id") Long id,
            @RequestParam("age") Integer age,
            @RequestParam("lastName") String lastName){
        return studentService.editStudent(id,age,lastName);
    }
    @DeleteMapping("/{id}")
    public Boolean deleteStudent(@PathVariable("id") Long id){
        return studentService.deleteStudent(id);
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }
}
