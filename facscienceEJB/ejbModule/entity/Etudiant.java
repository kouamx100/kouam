/**
 * 
 */
package entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import com.google.gson.Gson;

/**
 * @author kouam rodrigue
 * 
 */
@Entity
public class Etudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	private String matricule;

	@Column
	private String nom;
	private String prenom;
	private String motDePasse;

	@Temporal(TemporalType.DATE)
	private Date dateNais;

	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Examen> examens = new ArrayList<Examen>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiant")
	private Collection<Requettes> requettes = new ArrayList<Requettes>();

	public Collection<Requettes> getRequettes() {
		return requettes;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public void setRequettes(Collection<Requettes> requettes) {
		this.requettes = requettes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNais() {
		return dateNais;
	}

	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}

	public Collection<Examen> getExament() {
		return examens;
	}

	public void setExament(Collection<Examen> examen) {
		this.examens = examen;
	}

	public String toGson() {
		return new Gson().toJson(this);
	}

	public String toString() {
		return "Etudiant [id=" + id + " ,matricule=" + matricule + " ,nom="
				+ nom + " ,prenom=" + prenom + " ,mot de passe" + motDePasse
				+ " ,date de nassance=" + dateNais+"]";
	}

}