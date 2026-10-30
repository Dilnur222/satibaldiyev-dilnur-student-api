package com.satibaldiyev.studentapi;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String groupName;
    @NotNull
    private Integer studentId;

    public Student() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
    public String getSurname() { return surname; }
    public void setSurname(String value) { this.surname = value; }
    public String getGroupName() { return groupName; }
    public void setGroupName(String value) { this.groupName = value; }
    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer value) { this.studentId = value; }
}
