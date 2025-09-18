package com.codegym.c0525g1.controller;

import com.codegym.c0525g1.entity.Student;
import com.codegym.c0525g1.service.IStudentService;
import com.codegym.c0525g1.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

  private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getAllStudents(Model model) {
        List<Student> students = studentService.findAll();
//        Phân biệt Model, ModelMap và ModelAndView
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("/create")
    public String createStudent(ModelMap model) {
        model.addAttribute("student", new Student());
        return "student/create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student")Student student, BindingResult bindingResult, RedirectAttributes redirect) {
        if(bindingResult.hasErrors()) {
            return "student/create";
        }
        studentService.save(student);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable Integer id, ModelMap model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student/info";
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleNumberFormatException(NumberFormatException ex) {
        return "redirect:/error";
    }
}
