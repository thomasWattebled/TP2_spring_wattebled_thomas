package com.example.demo.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.agenda.Agenda;
import com.example.demo.agenda.AgendaService;
import com.example.demo.evenement.Evenement;
import com.example.demo.evenement.EvenementService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/agenda")
public class EvenementController {
	
	@Autowired
	private EvenementService evenementService;
	
	@Autowired
	private AgendaService agendaService;
	private Agenda agenda;
	
	@GetMapping("/agenda/{nom}")
	public String home_agenda(@PathVariable String nom,HttpSession session,Model model) {
		agenda = agendaService.getAgendaByName(nom, (Long)session.getAttribute("id")); ;
		List<Evenement> evenements = new ArrayList<>();
		evenements = evenementService.getEvenementById(agenda.getId());
		//System.out.println(agendas);		
		//agendas.add(new Agenda(1,"test"));
		model.addAttribute(agenda);
		model.addAttribute("evenements",evenements);
		return "evenement";
	}
	
	@GetMapping("delete/{libelle}")
	public String delete_evenement(@PathVariable String libelle) {
		Evenement evenement = evenementService.findEvenementByLibelle(libelle);
		evenementService.deletEvenement(evenement);
		return "redirect:/agenda/agenda/"+ agenda.getNom();
	}
	
	@PostMapping("/addEvenement")
	public String addAgenda(@RequestParam String date, @RequestParam String h_deb, @RequestParam String h_fin, @RequestParam String libelle) {
		
		 evenementService.ajouterEvenement(date, h_deb, h_fin, libelle, agenda.getId());
		//Agenda agenda = new Agenda((Long)session.getAttribute("id"),nom);
		
		return "redirect:/agenda/agenda/"+ agenda.getNom();
	}
	 
	@PostMapping("/retour")
	public String logout() {
		return "redirect:/agenda/user";
	} 
}
