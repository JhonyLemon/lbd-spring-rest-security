package pl.fissst.lbd.restsecurity.services;

import org.springframework.stereotype.Service;
import pl.fissst.lbd.restsecurity.dto.Teacher;
import pl.fissst.lbd.restsecurity.dto.enums.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherService {

    List<Teacher> teachers;
    private Long currentId=0L;
    private Map<Long,Teacher> index;

    StudentService studentService;

    public TeacherService(StudentService studentService) {
        this.studentService=studentService;
        this.teachers = new ArrayList<>();
        this.index = new HashMap<>();
        addTeacher(new Teacher(
                1L,
                "Kuba",
                "Udo",
                Subject.ALGEBRA
        ));
        addTeacher(new Teacher(
                2L,
                "Jakub",
                "Lis",
                Subject.BIOLOGY
        ));
        addTeacher(new Teacher(
                3L,
                "Magdalena",
                "Wierzba",
                Subject.LAW
        ));
    }

    private Teacher addTeacher(Teacher teacher){
        if(teacher==null)
            throw new NullPointerException("Teacher object cannot be null");
        currentId++;
        teacher.setId(currentId);
        teachers.add(teacher);
        index.put(currentId,teacher);
        return teacher;
    }

    private List<Teacher> addTeachers(Teacher[] teachers){
        for (Teacher teacher: teachers) {
            addTeacher(teacher);
        }
        return this.teachers;
    }



}
