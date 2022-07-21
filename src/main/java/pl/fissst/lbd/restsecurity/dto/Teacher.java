package pl.fissst.lbd.restsecurity.dto;

import pl.fissst.lbd.restsecurity.dto.enums.Subject;

public class Teacher {

    private Long id;
    private String firstName;
    private String lastName;
    private Subject subject;

    public Teacher(Long id, String firstName, String lastName, Subject subject) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public Teacher() {
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
