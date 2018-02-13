package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entite.Banque;
import dev.entite.Collaborateur;
import dev.repository.CollaborateurRepository;
import dev.repository.banqueRepository;

@RestController
@RequestMapping("/collaborateurs")
public class CollaborateurController {

	@Autowired
	private CollaborateurRepository collaborateurRepo;

	@GetMapping
	public List<Collaborateur> listerexemples() {
		return this.collaborateurRepo.findAll();
	}

	@GetMapping("/cooBanq={matricule}")
	public String listerBanque(@PathVariable String matricule) {

		Collaborateur collabBDD = this.collaborateurRepo.findByMatricule(matricule);
		if (collabBDD != null) {
			return "coordonnee bancaire= " + collabBDD.getBanque().getCoordonneBancaire();
		}

		return "error pas trouvé de matricule";

	}

	@Autowired
	banqueRepository banqueRepo;

	@PutMapping("/cooBanq={matricule}")
	public ResponseEntity<?> modifierCooBanque(@PathVariable String matricule, @RequestBody Banque banq) {

		Collaborateur collabBDD = this.collaborateurRepo.findByMatricule(matricule);
		if ((collabBDD != null) && (banq != null)) {
			collabBDD.getBanque().setCoordonneBancaire(banq.getCoordonneBancaire());
			collaborateurRepo.save(collabBDD);

			return ResponseEntity.ok(this.collaborateurRepo.findAll());
		}
		return ResponseEntity.status(400).body("OOpps pas trouvé");
	}

	@PutMapping("/{matricule}")
	public ResponseEntity<?> modifierUnCollaborateur(@PathVariable String matricule,
			@RequestBody Collaborateur collaborateur) {

		Collaborateur collabBDD = this.collaborateurRepo.findByMatricule(matricule);

		if ((collabBDD != null) && (collaborateur != null)) {
			collabBDD.setMatricule(collaborateur.getMatricule());
			collaborateurRepo.save(collabBDD);
			return ResponseEntity.ok(this.collaborateurRepo.findAll());

		} else {
			return ResponseEntity.status(400).body("OOpps pas trouvé");
		}
	}
}