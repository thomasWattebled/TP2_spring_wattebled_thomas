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

import com.example.demo.Agenda;
import com.example.demo.Personne;
import com.example.demo.PersonneService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PersonneController {
	
	@Autowired
	private PersonneService service;
	
	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}
	 private List<Agenda> agendas;
	
	@GetMapping("/home/agenda")
	public String home_agenda(HttpSession session,Model model) {
		List<Agenda> agendas = new ArrayList<>();
		agendas = service.getAgendaById((Long)session.getAttribute("id"));
		//System.out.println(agendas);		
		//agendas.add(new Agenda(1,"test"));
		model.addAttribute("agendas",agendas);
		return "agenda";
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
	
	@PostMapping("/login")
	public String agendaPersonne ( HttpSession session,@RequestParam String email, @RequestParam String mdp) {
		ArrayList<Personne>personnes = (ArrayList<Personne>) service.getByEmail(email) ;
		if(personnes.get(0).getMdp().equals(mdp)) {
			session.setAttribute("email",personnes.get(0).getEmail());
			session.setAttribute("id",personnes.get(0).getId());
			session.setAttribute("nom",personnes.get(0).getNom());
			session.setAttribute("prenom",personnes.get(0).getPrenom());
			session.setAttribute("agenda",personnes.get(0).getAgenda());
			return "redirect:/home/agenda";
		}
		else {
			return "/home";
		}
		//System.out.println(personnes.size());
		//System.out.println("bonjour "+ personnes.get(0).getEmail()+ " " + personnes.get(0).getPrenom()+ " "+ personnes.get(0).getMdp()+ " "+ personnes.get(0).getNom() );
		//model.addAttribute("personnes",personnes);
		//return "/agenda";
	}
	
	@PostMapping("/logout")
	public String logout() {
		return "redirect:/home";
	}
	
	@PostMapping("/addAgenda")
	public String addAgenda(HttpSession session,@RequestParam String nom) {
		service.ajouterAgenda((Long)session.getAttribute("id"),nom);
		//Agenda agenda = new Agenda((Long)session.getAttribute("id"),nom);
		
		return "redirect:/home/agenda";
	}
	
	
	
	
}
