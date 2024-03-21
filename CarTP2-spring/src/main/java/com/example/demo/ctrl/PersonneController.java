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

import com.example.demo.agenda.Agenda;
import com.example.demo.personne.Personne;
import com.example.demo.personne.PersonneService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/agenda")
public class PersonneController {
	
	@Autowired
	private PersonneService service;
	
	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}
	 private List<Agenda> agendas;
	
	
	@PostMapping("/init")
	public String init() {
		service.init();
		return "redirect:/home";
	}
	
	@PostMapping("/addUser")
	public String addPersonne ( @RequestParam String email, @RequestParam String mdp, @RequestParam String nom, @RequestParam String prenom) {
		System.out.println("j'envoie l'email" + email);
		service.ajouterPersonne(email,mdp,nom,prenom);
		return "redirect:/agenda/home";
	}
	
	@PostMapping("/login")
	public String agendaPersonne ( HttpSession session,@RequestParam String email, @RequestParam String mdp) {
		ArrayList<Personne>personnes = (ArrayList<Personne>) service.getByEmail(email) ;
		if(personnes.size() >0 && personnes.get(0).getMdp().equals(mdp)) {
			session.setAttribute("email",personnes.get(0).getEmail());
			session.setAttribute("id",personnes.get(0).getId());
			session.setAttribute("nom",personnes.get(0).getNom());
			session.setAttribute("prenom",personnes.get(0).getPrenom());
			session.setAttribute("agenda",personnes.get(0).getAgenda());
			return "redirect:/agenda/user";
		}
		else {
			return "redirect:/agenda/home";
		}
		//System.out.println(personnes.size());
		//System.out.println("bonjour "+ personnes.get(0).getEmail()+ " " + personnes.get(0).getPrenom()+ " "+ personnes.get(0).getMdp()+ " "+ personnes.get(0).getNom() );
		//model.addAttribute("personnes",personnes);
		//return "/agenda";
	}
	
	
	
	
	
	
	
}
