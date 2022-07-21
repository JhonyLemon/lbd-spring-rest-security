package pl.fissst.lbd.restsecurity.services;

import org.springframework.stereotype.Service;
import pl.fissst.lbd.restsecurity.dto.Student;
import pl.fissst.lbd.restsecurity.dto.enums.Subject;

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
                ),
                new Student(
                        null,
                        "Jan",
                        "Pleśniak",
                        20,
                        new ArrayList<>(Arrays.asList(Subject.ALGEBRA, Subject.LAW))
                ),
                new Student(
                        null,
                        "Kacper",
                        "Pole",
                        20,
                        new ArrayList<>(Arrays.asList(Subject.BIOLOGY,Subject.LAW))
                ),
                new Student(
                        null,
                        "Michael",
                        "Prostokąt",
                        15,
                        new ArrayList<>(Arrays.asList(Subject.ALGEBRA,Subject.BIOLOGY))
                ),
                new Student(
                        null,
                        "Zdzisław",
                        "Romb",
                        16,
                        new ArrayList<>(Arrays.asList(Subject.ALGEBRA,Subject.LAW))
                ),
                new Student(
                        null,
                        "Kamil",
                        "Cośik",
                        19,
                        new ArrayList<>(Arrays.asList(Subject.BIOLOGY,Subject.LAW))
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

    public Student insertStudent(Student student) {
        return addStudent(student);
    }

    public Student editStudent(Long id,Integer age, String lastName){
        if(age<=0)
            throw new IllegalArgumentException("Age cannot be negative");
        Student student = index.get(id);
        if(student!=null){
            student.setLastName(lastName);
            student.setAge(age);
            return student;
        }
        throw new NoSuchElementException("Student with given id not found");
    }

    public Boolean deleteStudent(Long id){
        Student student = index.get(id);
        if(student!=null){
            index.remove(student);
            if(students.remove(student))
                return true;
            else
                throw new IllegalStateException("Failed to delete student");
        }
        throw new NoSuchElementException("Student with given id not found");
    }

    public Student getStudent(Long id){
        Student student = index.get(id);
        if(student!=null){
            return student;
        }
        throw new NoSuchElementException("Student with given id not found");
    }

}
