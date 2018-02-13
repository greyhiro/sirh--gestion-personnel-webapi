package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.Banque;

public interface banqueRepository extends JpaRepository<Banque, Integer> {

}
