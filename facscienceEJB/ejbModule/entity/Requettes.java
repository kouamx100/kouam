package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.google.gson.Gson;

/**
 * @author kouam rodrigue
 * 
 */

@Entity
public class Requettes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, length = 30)
	private String objet;

	private String description;

	private String codeMatiere;

	@ManyToOne
	@JoinColumn(name = "etudiant")
	Etudiant etudiant = new Etudiant();

	public Requettes() {

	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the objet
	 */
	public String getObjet() {
		return objet;
	}

	/**
	 * @param objet
	 *            the objet to set
	 */
	public void setObjet(String objet) {
		this.objet = objet;
	}

	/**
	 * @return the codeMatiere
	 */
	public String getCodeMatiere() {
		return codeMatiere;
	}

	/**
	 * @param codeMatiere
	 *            the codeMatiere to set
	 */
	public void setCodeMatiere(String codeMatiere) {
		this.codeMatiere = codeMatiere;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public String toGson() {
		return new Gson().toJson(this, Requettes.class);
	}

	public String toString() {
		return "Requettes=[id=" + id + " ,objet=" + objet + " ,description="
				+ description + " ,code de la matiere=" + codeMatiere
				+ " ,nom de l\'etudiant=" + this.getEtudiant().getNom()+"]";
	}

}