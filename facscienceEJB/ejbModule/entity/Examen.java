/**
 * 
 */
package entity;

import java.util.Date;

import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.AssociationOverride;
import javax.persistence.JoinColumn;

import com.google.gson.Gson;

/**
 * @author kouam Rodrigue
 * 
 */

@Entity
@AssociationOverrides({
		@AssociationOverride(name = "pk.etudiant", joinColumns = @JoinColumn(name = "id")),
		@AssociationOverride(name = "pk.matiere", joinColumns = @JoinColumn(name = "code")) })
public class Examen {

	@EmbeddedId
	private ExamenId examenId;

	@Temporal(TemporalType.DATE)
	private Date dateExam;

	private String session;

	private int note;

	@Transient
	public Matiere getMatiere() {
		return getExamenId().getMatiere();
	}

	public void setMatiere(Matiere matiere) {
		getExamenId().setMatiere(matiere);
	}

	@Transient
	public Etudiant getEtudiant() {
		return getExamenId().getEtudiant();
	}

	public void setEtudiant(Etudiant etudiant) {
		getExamenId().setEtudiant(etudiant);
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	/**
	 * @return the session
	 */
	public String getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(String session) {
		this.session = session;
	}

	/**
	 * @return the examenId
	 */
	public ExamenId getExamenId() {
		return examenId;
	}

	/**
	 * @param examenId
	 *            the examenId to set
	 */
	public void setExamenId(ExamenId examenId) {
		this.examenId = examenId;
	}

	/**
	 * @return the dateExam
	 */
	public Date getDateExam() {
		return dateExam;
	}

	/**
	 * @param dateExam
	 *            the dateExam to set
	 */
	public void setDateExam(Date dateExam) {
		this.dateExam = dateExam;
	}

	public String toGson() {
		return new Gson().toJson(this);
	}

	public String toString() {
		return "Examen=[date examen=" + dateExam + " ,session=" + session
				+ " ,note=" + note + " ]";
	}

}