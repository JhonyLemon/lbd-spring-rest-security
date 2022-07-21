package pl.fissst.lbd.restsecurity.controllers;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Student>> getAllStudent(){

        return ResponseEntity
                .ok()
                .header("successful","true")
                .body(studentService.getAllStudents());
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return ResponseEntity
                .ok()
                .header("successful","true")
                .body(studentService.insertStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> editStudent(
            @PathVariable("id") Long id,
            @RequestParam("age") Integer age,
            @RequestParam("lastName") String lastName){
        return ResponseEntity
                .ok()
                .header("successful","true")
                .body(studentService.editStudent(id,age,lastName));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable("id") Long id){
        return ResponseEntity
                .ok()
                .header("successful","true")
                .body(studentService.deleteStudent(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id){
        return ResponseEntity
                .ok()
                .header("successful","true")
                .body(studentService.getStudent(id));
    }

}
