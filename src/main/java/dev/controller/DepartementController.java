package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entite.Departement;
import dev.repository.DepartementReposity;

@RestController
@RequestMapping("/departements")
public class DepartementController {

	@Autowired
	private DepartementReposity departementRepo;

	@GetMapping
	public List<Departement> listerexemples() {
		return this.departementRepo.findAll();
	}

}
