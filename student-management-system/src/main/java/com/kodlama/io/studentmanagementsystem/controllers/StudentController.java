package com.kodlama.io.studentmanagementsystem.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kodlama.io.studentmanagementsystem.business.abstracts.IStudentService;
import com.kodlama.io.studentmanagementsystem.business.requests.CreateStudentRequest;
import com.kodlama.io.studentmanagementsystem.business.requests.UpdateStudentRequest;
import com.kodlama.io.studentmanagementsystem.entities.Student;

import lombok.AllArgsConstructor;

@RequestMapping("/api/students")
@Controller
@AllArgsConstructor
public class StudentController {

	private IStudentService iStudentService;

	@GetMapping("/getAll")
	public ModelAndView getAllStudent() {
		ModelAndView andView = new ModelAndView("list-students");
		andView.addObject("students", this.iStudentService.getAllStudent());

		return andView;

	}

	@GetMapping("/new")
	public ModelAndView createStudent(CreateStudentRequest createStudentRequest) {
		ModelAndView andView = new ModelAndView("create-students");

		andView.addObject(createStudentRequest);

		return andView;

	}

	@PostMapping("/add")
	public String saveStudent(@Valid CreateStudentRequest createStudentRequest, Errors bindingResult) {

		boolean thereAreErrors = bindingResult.hasErrors();

		if (thereAreErrors) {

			return "create-students";

		}
		this.iStudentService.addStudent(createStudentRequest);

		return "redirect:/api/students/getAll";

	}

	@GetMapping("/update")
	public ModelAndView createStudent(UpdateStudentRequest request) {
		ModelAndView andView = new ModelAndView("update-students");

		Student student = this.iStudentService.getById(request.getId());

		andView.addObject("student", student);

		return andView;

	}

	@PostMapping("/studentUpdate")
	public String updateStudent(@ModelAttribute("request") UpdateStudentRequest request) {

		this.iStudentService.updateStudent(request);

		return "redirect:/api/students/getAll";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {

		this.iStudentService.deleteStudent(id);

		return "redirect:/api/students/getAll";
	}

}
