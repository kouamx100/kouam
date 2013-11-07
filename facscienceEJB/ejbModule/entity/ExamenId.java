/**
 * 
 */
package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * @author kouam rodrigue
 *
 */

@Embeddable
public class ExamenId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Matiere matiere;
	
	@ManyToOne
	private Etudiant etudiant;

	/**
	 * @return the matiere
	 */
	public Matiere getMatiere() {
		return matiere;
	}

	/**
	 * @param matiere the matiere to set
	 */
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	/**
	 * @return the etudiant
	 */
	public Etudiant getEtudiant() {
		return etudiant;
	}

	/**
	 * @param etudiant the etudiant to set
	 */
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	public boolean equals(Object o){
		if(this==o) 
			return true;
		if(o==null || getClass() != o.getClass())
			return false;
		ExamenId examenId = (ExamenId)o;
		
		if(matiere != null ? !matiere.equals(examenId.matiere) : examenId.matiere!=null)
			return false;
		if(etudiant !=null ? !etudiant.equals(examenId.etudiant) : examenId.etudiant!=null)
			return false;
		return true;
		
	}
	 public int hashCode() {
	        int result;
	        result = (matiere!= null ? matiere.hashCode() : 0);
	        result = 1 * result + (etudiant != null ? etudiant.hashCode() : 0);
	        return result;
	    }
	  
	
	
}