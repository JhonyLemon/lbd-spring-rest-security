package pl.fissst.lbd.restsecurity.dto;

import pl.fissst.lbd.restsecurity.dto.enums.Subject;

import java.util.List;

public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private List<Subject> subjects;

    public Student(Long id, String firstName, String lastName, Integer age, List<Subject> subjects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.subjects = subjects;
    }

    public Student(Long id, String firstName, String lastName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
