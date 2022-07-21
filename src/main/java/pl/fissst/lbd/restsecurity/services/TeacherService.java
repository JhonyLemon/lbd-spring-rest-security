package pl.fissst.lbd.restsecurity.services;

import org.springframework.stereotype.Service;
import pl.fissst.lbd.restsecurity.dto.Student;
import pl.fissst.lbd.restsecurity.dto.Teacher;
import pl.fissst.lbd.restsecurity.dto.enums.Subject;

import java.util.*;
import java.util.stream.Collectors;

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

    public Teacher insertTeacher(Teacher teacher){
        if(teachers.stream().filter(x-> x.getSubject()==teacher.getSubject()).count()==0) {
            return addTeacher(teacher);
        }
        throw new IllegalArgumentException("Subject must be unique");
    }
    public Boolean deleteTeacher(Long id){
        Teacher teacher = index.get(id);
        if(teacher!=null){
            index.remove(teacher);
            if(teachers.remove(teacher))
                return true;
            else
                throw new IllegalStateException("Failed to delete teacher");
        }
        throw new NoSuchElementException("Teacher with given id not found");
    }
    public Teacher getTeacher(Long id){
        Teacher teacher = index.get(id);
        if(teacher!=null){
            return teacher;
        }
        throw new NoSuchElementException("Teacher with given id not found");
    }
    public List<Student> getTeacherClass(Long id){
        Teacher teacher = index.get(id);
        if(teacher!=null){
            List<Student> list= studentService.getAllStudents()
                    .stream()
                    .filter(x-> x.getSubjects()!=null && x.getSubjects().contains(teacher.getSubject()))
                    .collect(Collectors.toList());
            if(list.size()==0)
                throw new NoSuchElementException("No students in teacher class found");
            else
                return list;
        }
        throw new NoSuchElementException("Teacher with given id not found");
    }

    public Boolean deleteStudentFromClassByTeacherId(Long studentId,Long teacherId){
        Teacher teacher = index.get(teacherId);
        if(teacher!=null){
            if(studentService.getStudent(studentId).getSubjects().remove(teacher.getSubject()))
                return true;
            else
                throw new IllegalStateException("Failed to delete student from class");
        }
        throw new NoSuchElementException("Teacher with given id not found");
    }

}
