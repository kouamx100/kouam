/**
 * 
 */
package entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.Gson;

/**
 * @author kouam rodrigue
 * 
 */

@Entity
public class Filiere {

	@Id
	private String libele;

	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	private String departement;

	@OneToMany(mappedBy = "filiere", cascade=CascadeType.ALL)
	private Collection<Enseignant> enseignant = new ArrayList<Enseignant>();

	/**
	 * @return the enseignant
	 */
	public Collection<Enseignant> getEnseignant() {
		return enseignant;
	}

	/**
	 * @param enseignant
	 *            the enseignant to set
	 */
	public void setEnseignant(Collection<Enseignant> enseignant) {
		this.enseignant = enseignant;
	}

	public String getLibele() {
		return libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String toGson() {
		return new Gson().toJson(this, Filiere.class);
	}

	public String toString() {
		return "Filiere =[libele=" + libele + " ,date de creation="
				+ dateCreation + " ,departement=" + departement+"]";
	}
}