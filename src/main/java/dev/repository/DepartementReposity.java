package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.Departement;

public interface DepartementReposity extends JpaRepository<Departement, Integer> {
}
