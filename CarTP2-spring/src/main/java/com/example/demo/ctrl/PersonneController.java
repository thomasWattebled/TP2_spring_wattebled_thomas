package com.example.demo.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Personne;

@Controller
public class PersonneController {
	
	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}
	
}
