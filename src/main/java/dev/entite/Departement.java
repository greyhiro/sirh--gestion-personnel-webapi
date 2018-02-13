package dev.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Departement")
public class Departement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomDepartement;
	private Integer numeroDepartement;

	@ManyToOne
	@JoinColumn(name = "COL_id")
	private Collaborateur collaborateur;

	/**
	 * @return the collaborateur
	 */
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	/**
	 * @param collaborateur
	 *            the collaborateur to set
	 */
	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nomDepartement
	 */
	public String getNomDepartement() {
		return nomDepartement;
	}

	/**
	 * @param nomDepartement
	 *            the nomDepartement to set
	 */
	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	/**
	 * @return the numeroDepartement
	 */
	public Integer getNumeroDepartement() {
		return numeroDepartement;
	}

	/**
	 * @param numeroDepartement
	 *            the numeroDepartement to set
	 */
	public void setNumeroDepartement(Integer numeroDepartement) {
		this.numeroDepartement = numeroDepartement;
	}

}
