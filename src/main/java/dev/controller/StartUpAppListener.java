package dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dev.entite.Banque;
import dev.entite.Collaborateur;
import dev.entite.Departement;
import dev.repository.CollaborateurRepository;
import dev.repository.DepartementReposity;
import dev.repository.banqueRepository;

@Component
public class StartUpAppListener {
	@Autowired
	DepartementReposity dr;

	@Autowired
	CollaborateurRepository collab;

	@Autowired
	banqueRepository banq;

	@Autowired
	DepartementReposity dep;

	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void contextRefreshedEvent() {
		Departement departement = new Departement();
		departement.setNomDepartement("RH");
		departement.setNumeroDepartement(22);

		dep.save(departement);

		Collaborateur collaborateur = new Collaborateur();
		collaborateur.setMatricule("M01");
		collaborateur.setAdresse("8 chemin des pommes....");
		collaborateur.setDateDeNaissance(null);
		collaborateur.setActif(true);
		collaborateur.setNom("patric");
		departement.setCollaborateur(collaborateur);
		dep.save(departement);

		Banque banque = new Banque();

		banque.setCollaborateur(collaborateur);
		banque.setNom("La poste");
		banque.setCoordonneBancaire("805124A2125");
		collaborateur.setBanque(banque);

		banq.save(banque);
		collab.save(collaborateur);

		Collaborateur collaborateur2 = new Collaborateur();

		collaborateur2.setMatricule("M05");
		collaborateur2.setAdresse("8 chemin des chocolat....");
		collaborateur2.setDateDeNaissance(null);
		collaborateur2.setActif(true);
		collaborateur2.setNom("LOU");

		Banque banque2 = new Banque();
		banque2.setCollaborateur(collaborateur2);
		banque2.setNom("LCL");
		banque2.setCoordonneBancaire("1554F415454543");
		banque2.setCollaborateur(collaborateur2);
		collaborateur2.setBanque(banque2);

		Departement departement2 = new Departement();
		departement2.setNomDepartement("TECHNIQUE");
		departement2.setNumeroDepartement(21);
		departement2.setCollaborateur(collaborateur2);
		dep.save(departement2);

		banq.save(banque2);
		collab.save(collaborateur2);

	}

}
