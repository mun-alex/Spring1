package kz.bitlab.spring.firstproject.db;

import kz.bitlab.spring.firstproject.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsDBManager {
    private static List<Student> studentList = new ArrayList<>();
    private static Long id =4L;

    static {
        studentList.add(new Student(0L, "Madi", "Alpamys", 92, null));
        studentList.add(new Student(1L, "Sanzhar", "Bitimbayev", 80, null));
        studentList.add(new Student(2L, "Daniyar", "Bulegenov", 75, null));
        studentList.add(new Student(3L, "Madi", "Kabdygali", 85, null));
        studentList.add(new Student(4L, "Yerlan", "Koishybaiuly", 45, null));
    }

    public static List<Student> getAllStudents() {
        return studentList;
    }

    public static void addStudent(Student student) {
        student.setId(id++);
        studentList.add(student);
    }

    public static Student getStudentById(Long id) {
        return studentList.get(Integer.parseInt(id.toString()));
    }

    public static void updateStudent(Student student) {
        studentList.set(Integer.parseInt(student.getId().toString()), student);
    }

    public static void delete(int index) {
        studentList.remove(index);
    }
}
