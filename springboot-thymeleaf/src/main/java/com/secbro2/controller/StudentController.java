package com.secbro2.controller;

import com.secbro2.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/14 9:32 AM
 **/
@Controller
public class StudentController {

	@GetMapping("/")
	public String getStudents(Model model){

		List<Student> list = new ArrayList<>();

		Student s1 = new Student();
		s1.setIdNo("N01");
		s1.setName("Tom");
		list.add(s1);

		Student s2 = new Student();
		s2.setIdNo("N02");
		s2.setName("David");
		list.add(s2);

		model.addAttribute("students",list);
		model.addAttribute("hello","Hello Thymeleaf!");

		return "student";

	}
}
