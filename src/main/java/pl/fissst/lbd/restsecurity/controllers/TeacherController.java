package pl.fissst.lbd.restsecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fissst.lbd.restsecurity.dto.Student;
import pl.fissst.lbd.restsecurity.dto.Teacher;
import pl.fissst.lbd.restsecurity.services.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
        return ResponseEntity
                .ok()
                .header("successful","true")
                .body(teacherService.insertTeacher(teacher));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTeacher(@PathVariable("id") Long id){
        return ResponseEntity
                .ok()
                .header("successful","true")
                .body(teacherService.deleteTeacher(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable("id") Long id){
        return ResponseEntity
                .ok()
                .header("successful","true")
                .body(teacherService.getTeacher(id));
    }
    @GetMapping("/{id}/class")
    public ResponseEntity<List<Student>> getTeacherClass(@PathVariable("id") Long id){
        return ResponseEntity
                .ok()
                .header("successful","true")
                .body(teacherService.getTeacherClass(id));
    }
    @PutMapping("/{teacherId}/class/remove/{studentId}")
    public ResponseEntity<Boolean> deleteStudentFromClassByTeacherId(@PathVariable("studentId") Long studentId,
                                                                     @PathVariable("teacherId") Long teacherId){
        return ResponseEntity
                .ok()
                .header("successful","true")
                .body(teacherService.deleteStudentFromClassByTeacherId(studentId,teacherId));
    }

}