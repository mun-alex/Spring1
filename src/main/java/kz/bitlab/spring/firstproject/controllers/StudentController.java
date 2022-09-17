package kz.bitlab.spring.firstproject.controllers;

import kz.bitlab.spring.firstproject.db.StudentsDBManager;
import kz.bitlab.spring.firstproject.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @GetMapping(value = "/students")
    public String getStudentsList(Model model) {
        List<Student> studentList = StudentsDBManager.getAllStudents();
        for (Student student : studentList) {
            student.setMark(getMark(student.getExam()));
        }
        model.addAttribute("students", studentList);
        return "students";
    }

    @GetMapping(value = "/students/add-new-student")
    public String getStudentForm(Model model) {
        model.addAttribute("newStudent", new Student());
        return "newStudent";
    }

    @PostMapping(value = "/students/add-new-student")
    public String addNewStudent(@ModelAttribute(name = "newStudent") Student newStudent) {
        newStudent.setMark(getMark(newStudent.getExam()));
        StudentsDBManager.addStudent(newStudent);
        return "redirect:";
    }

    @GetMapping(value = "/students/edit/{id}")
    public String getStudentEditForm(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("student", StudentsDBManager.getStudentById(id));
        return "editStudent";
    }

    @PostMapping(value = "/students/edit")
    public String updateStudent(@ModelAttribute(name = "student") Student student) {
        StudentsDBManager.updateStudent(student);
        return "redirect:";
    }

    @GetMapping(value = "/students/delete/{index}")
    public String delete(@PathVariable(name = "index") int index) {
        StudentsDBManager.delete(index);
        return "redirect:/students";
    }

    @GetMapping(value = "")

    private String getMark(int exam) {
        if (exam >= 90) return "A";
        else if (exam >= 75 && exam < 90) return "B";
        else if (exam >= 60 && exam < 75) return "C";
        else if (exam >= 50 && exam < 60) return "D";
        else return "F";
    }
}
