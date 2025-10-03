package com.codegym.c0525g1_spring_boot.controller;

import com.codegym.c0525g1_spring_boot.dto.StudentDto;
import com.codegym.c0525g1_spring_boot.entity.Student;
import com.codegym.c0525g1_spring_boot.service.IStudentService;
import com.codegym.c0525g1_spring_boot.service.impl.ClassroomService;
import com.codegym.c0525g1_spring_boot.validation.StudentValidation;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/students")
@SessionAttributes("cart")
public class StudentController {

    @ModelAttribute("cart")
    public Map<Student, Integer> initCart() {
        return new HashMap<>();
    }

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
    public String getAllStudents(Model model, @RequestParam(name = "page", defaultValue = "0")int page, HttpServletResponse response) {
//        Cookie cookie = new Cookie("language", "en");
//        cookie.setHttpOnly(true);
//        cookie.setMaxAge(60 * 60 * 24 * 365);
//        response.addCookie(cookie);
        Page<Student> students = studentService.findAllPageable(page);
//        Phân biệt Model, ModelMap và ModelAndView
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("/create")
    public String createStudent(ModelMap model, @CookieValue(value = "language", defaultValue = "")String language) {
        model.addAttribute("studentDto", new StudentDto());
        model.addAttribute("classrooms", classroomService.findAll());
        return "student/create";
    }

    @PostMapping("/create")
    public String createStudent(@Validated @ModelAttribute("studentDto")StudentDto studentDto, BindingResult bindingResult,@ModelAttribute("cart")Map<Student, Integer> cart, RedirectAttributes redirect,
                                Model model) {
        StudentValidation studentValidation = new StudentValidation();
        studentValidation.validate(studentDto, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("classrooms", classroomService.findAll());
            return "student/create";
        }

        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
//        if(cart.containsKey(student)) {
//
//        }else {
//            cart.put(student, 1);
//        }
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

    @GetMapping("/cart")
    public String viewCart(@ModelAttribute("cart")Map<Student, Integer> cart, Model model) {
        model.addAttribute("cart", cart);
        return "student/cart";
    }
}
