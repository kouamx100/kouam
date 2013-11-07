/**
 * 
 */
package entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Matiere {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code", nullable = false)
	private String code;

	String intitule;

	@Column(length = 30)
	private int credit;

	@ManyToOne
	@JoinColumn(name = "enseignantId")
	private Enseignant enseignant;

	@OneToMany()
	private Collection<Examen> examens = new ArrayList<Examen>();

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Collection<Examen> getExamens() {
		return examens;
	}

	public void setExamens(Collection<Examen> examens) {
		this.examens = examens;
	}

	public Matiere() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String toGson() {
		return new Gson().toJson(this, Matiere.class);
	}

	public String toString() {
		return "Matiere=[ code=" + code + " ,intitule=" + intitule
				+ " ,credit=" + credit + " ,enseignant="
				+ this.getEnseignant().getNom() + "]";
	}

}