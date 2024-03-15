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

import com.example.demo.agenda.Agenda;
import com.example.demo.agenda.AgendaService;
import com.example.demo.personne.PersonneService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
	
	@Autowired
	private AgendaService agendaService;
	
	@GetMapping("/user")
	public String home_agenda(HttpSession session,Model model) {
		List<Agenda> agendas = new ArrayList<>();
		agendas = agendaService.getAgendaById((Long)session.getAttribute("id"));
		//System.out.println(agendas);		
		//agendas.add(new Agenda(1,"test"));
		model.addAttribute("agendas",agendas);
		return "agenda";
	}
	
	
	@PostMapping("/addAgenda")
	public String addAgenda(HttpSession session,@RequestParam String nom) {
		agendaService.ajouterAgenda((Long)session.getAttribute("id"),nom);
		//Agenda agenda = new Agenda((Long)session.getAttribute("id"),nom);
		
		return "redirect:/agenda/user";
	}
	 
	@PostMapping("/logout")
	public String logout() {
		return "redirect:/agenda/home";
	} 
}
