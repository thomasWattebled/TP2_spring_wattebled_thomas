package com.example.demo.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Personne;
import com.example.demo.PersonneService;

@Controller
public class PersonneController {
	
	@Autowired
	private PersonneService service;
	
	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}
	
	@PostMapping("/init")
	public String init() {
		service.init();
		return "redirect:/home";
	}
	
	@PostMapping("/add")
	public String addPersonne ( @RequestParam String email, @RequestParam String mdp, @RequestParam String nom, @RequestParam String prenom) {
		System.out.println("j'envoie l'email" + email);
		service.ajouterPersonne(email,mdp,nom,prenom);
		return "redirect:/home";
	}
	
	@PostMapping("/agenda")
	public String agendaPersonne ( Model model ,@RequestParam String email, @RequestParam String mdp) {
		ArrayList<Personne>personnes = (ArrayList<Personne>) service.getByEmail(email) ;
		System.out.println(personnes.size());
		System.out.println("bonjour "+ personnes.get(0).getEmail()+ " " + personnes.get(0).getPrenom()+ " "+ personnes.get(0).getMdp()+ " "+ personnes.get(0).getNom() );
		model.addAttribute("personnes",personnes);
		return "/agenda";
	}
	
	
}
