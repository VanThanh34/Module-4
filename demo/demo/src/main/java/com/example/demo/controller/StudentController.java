package com.example.demo.controller;


import com.example.demo.entity.Student;
import com.example.demo.service.IStudentService;
import com.example.demo.service.impl.ClassroomService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/students")
public class StudentController {

  private final IStudentService studentService;
    private final ClassroomService classroomService;

    public StudentController(IStudentService studentService, ClassroomService classroomService) {
        this.studentService = studentService;
        this.classroomService = classroomService;
    }

//    @GetMapping
//    public String getAllStudents(Model model) {
//        List<Student> students = studentService.findAll();
////        Phân biệt Model, ModelMap và ModelAndView
//        model.addAttribute("students", students);
//        return "student/list";
//    }

    @GetMapping
    public String getAllStudents(Model model, @RequestParam(name = "page", defaultValue = "0")int page) {

        Page<Student> students = studentService.findAllPageable(page);
//        Phân biệt Model, ModelMap và ModelAndView
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("/create")
    public String createStudent(ModelMap model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classrooms", classroomService.findAll());
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
