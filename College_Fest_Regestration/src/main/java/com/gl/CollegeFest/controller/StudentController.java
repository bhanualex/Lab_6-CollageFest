package com.gl.CollegeFest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.CollegeFest.entity.Student;
import com.gl.CollegeFest.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/list")
	public String getAllStudents(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "student/student-list";
	}
	@GetMapping("/showStudentFormForAdd")
	public String showStudentFormForAdd(Model model) {
		 Student student = new Student();
		 model.addAttribute("student", student);
		 return "student/student-form";
	}
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		// save the book.
		studentService.save(student);
		// use a redirect to prevent duplicate submissions
		return "redirect:/student/list";
	}
	@GetMapping("/showStudentFormForEdit/{id}")
	public String showStudentFormForUpdate(Model model, @PathVariable int id) {
		// Get the student from db...
		Student student = studentService.findById(id);
		// set student as a model attribute to pre-populate the form
		model.addAttribute("student", student);
		return "student/student-form";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		// delete the Student
		studentService.deleteById(id);
		// set student as a model attribute to pre-populate the form
		return "redirect:/student/list";
	}

}
