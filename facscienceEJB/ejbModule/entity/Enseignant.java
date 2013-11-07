/**
 * 
 */
package entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.gson.Gson;

/**
 * @author kouam rodrigue
 * 
 */
@Entity
public class Enseignant {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, length = 30)
	private String nom;

	@Column(length = 30)
	private String prenom;

	@Column(length = 30)
	private String motDePass;
	
	@Column
	private Boolean estAdmin;

	@Column(length = 30)
	private String matricule;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "filiere")
	private Filiere filiere;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "enseignant")
	private Collection<Matiere> matieres = new ArrayList<Matiere>();

	public Enseignant() {

	}

	
	/**
	 * @return the estAdmin
	 */
	public Boolean getEstAdmin() {
		return estAdmin;
	}


	/**
	 * @param estAdmin the estAdmin to set
	 */
	public void setEstAdmin(Boolean estAdmin) {
		this.estAdmin = estAdmin;
	}


	public String getMotDePass() {
		return motDePass;
	}

	public void setMotDePass(String motDePass) {
		this.motDePass = motDePass;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	/**
	 * @return the matieres
	 */
	public Collection<Matiere> getMatieres() {
		return matieres;
	}

	/**
	 * @param matieres
	 *            the matieres to set
	 */
	public void setMatieres(Collection<Matiere> matieres) {
		this.matieres = matieres;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String toGson() {
		return new Gson().toJson(this);
	}

	public String toString() {
		return "Enseignant=[id=" + id + " ,nom=" + nom + " ,prenom=" + prenom
				+ " ,motdepasse=" + motDePass + " ,matricule=" + matricule
				+ " , filiere=" + this.getFiliere().getLibele()+"]";
	}

}