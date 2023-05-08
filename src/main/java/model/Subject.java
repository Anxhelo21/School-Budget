package model;

import java.util.List;

public class Subject {
    private int id;
    private String name;
    private Teacher teacher;
    private List<Student> studentList;

    public Subject(int id, String name, Teacher teacher, List<Student> studentList) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.studentList = studentList;
    }

    public Subject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "ID Number: " + id + "\nName: " + name + "\nmodel.Teacher: " + teacher + "\nStudents: "+studentList;
    }
}