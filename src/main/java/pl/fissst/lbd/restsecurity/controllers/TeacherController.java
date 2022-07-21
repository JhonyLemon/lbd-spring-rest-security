package pl.fissst.lbd.restsecurity.controllers;

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
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherService.insertTeacher(teacher);
    }
    @DeleteMapping("/{id}")
    public Boolean deleteTeacher(@PathVariable("id") Long id){
        return teacherService.deleteTeacher(id);
    }
    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable("id") Long id){
        return teacherService.getTeacher(id);
    }
    @GetMapping("/{id}/class")
    public List<Student> getTeacherClass(@PathVariable("id") Long id){
        return teacherService.getTeacherClass(id);
    }
    @PutMapping("/{teacherId}/class/remove/{studentId}")
    public Boolean deleteStudentFromClassByTeacherId(@PathVariable("studentId") Long studentId,
                                                     @PathVariable("teacherId") Long teacherId){
        return teacherService.deleteStudentFromClassByTeacherId(studentId,teacherId);
    }

}