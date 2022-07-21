package pl.fissst.lbd.restsecurity.services;

import org.springframework.stereotype.Service;
import pl.fissst.lbd.restsecurity.dto.Student;

import java.util.*;

@Service
public class StudentService {

    private List<Student> students;
    private Long currentId=0L;
    private Map<Long,Student> index;

    public StudentService() {
        this.students= new ArrayList<>();
        this.index = new HashMap<>();
        addStudents(new Student[]{
                new Student(
                        null,
                        "Adam",
                        "Nos",
                        22
                ),
                new Student(
                        null,
                        "Kazimierz",
                        "Polak",
                        66
                ),
                new Student(
                        null,
                        "Bogumił",
                        "Raban",
                        10
                ),
                new Student(
                        null,
                        "Bożydar",
                        "Lin",
                        90
                ),
                new Student(
                        null,
                        "Paweł",
                        "Nowak",
                        30
                )
        });
    }

    public List<Student> getAllStudents(){
        return students;
    }

    private Student addStudent(Student student){
        if(student==null)
            throw new NullPointerException("Student object cannot be null");
        currentId++;
        student.setId(currentId);
        students.add(student);
        index.put(currentId,student);
        return student;
    }

    private List<Student> addStudents(Student[] students){
        for (Student student: students) {
            addStudent(student);
        }
        return this.students;
    }

}
