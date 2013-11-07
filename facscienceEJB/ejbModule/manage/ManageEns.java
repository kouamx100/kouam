package manage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.google.gson.Gson;

import entity.Enseignant;
import entity.Filiere;
import entity.Matiere;

/**
 * Session Bean implementation class ManageEns
 */
@Stateless
public class ManageEns implements ManageEnsRemote {

	/**
	 * Default constructor.
	 */
	public ManageEns() {

	}

	@PersistenceContext
	EntityManager em;

	public Map<String, Object> create(String nom, String prenom,
			String libelefil, String motDePass) {

		HashMap<String, Object> result = new HashMap<String, Object>();
		Collection<Matiere> matieres = new ArrayList<Matiere>();
		Enseignant enseignant = new Enseignant();

		try {
			enseignant.setEstAdmin(false);
			enseignant.setNom(nom);
			enseignant.setPrenom(prenom);
			Filiere filiere = em.find(Filiere.class, libelefil);
			enseignant.setFiliere(filiere);
			enseignant.setMotDePass(motDePass);
			enseignant.setMatieres(matieres);
			long id = (Long) em.createQuery(
					"select count(e) from Enseignant as e").getSingleResult();

			/* le matricule est sous le format uds-id */
			id += 1;
			String matricule = "uds-" + id;
			enseignant.setMatricule(matricule);
			em.persist(enseignant);
			result.put("code", 1);
		} catch (Exception ex) {
			result.put("code", "2");
			result.put("message", "Error when creating a Enseignant");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}

	public HashMap<String, Object> edit(Enseignant enseignant) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			em.getTransaction().begin();
			em.merge(enseignant);
			result.put("code", 1);
			em.getTransaction().commit();
		} catch (Exception ex) {
			result.put("code", 2);
			result.put("message", "error when editing Enseignant");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}

	public HashMap<String, Object> destroy(long id) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			Enseignant enseignant = em.find(Enseignant.class, id);
			em.remove(enseignant);
			result.put("code", 1);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			result.put("code", 2);
			result.put("message", "error when destroy a filiere");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Object> findAll(String dataresult) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			Query query = em
					.createQuery("select object(o) from Enseignant as o");
			List<Enseignant> resultist = query.getResultList();
			if ("gson".equals(dataresult)) {
				String json = new Gson().toJson(resultist);
				result.put("data", json);
			} else {
				result.put("data", resultist);
			}
			result.put("code", 1);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			result.put("code", 2);
			result.put("message", "error when destroy a filiere");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}

	public HashMap<String, Object> findEnseignant(String matricule,
			String motDePass) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			Query query = em
					.createQuery("select object(e) from Enseignant as e where e.matricule= :matricule and e.motDePass= :motDePass");
			query.setParameter("matricule", matricule);
			query.setParameter("motDePass", motDePass);
			Enseignant enseignant = (Enseignant) query.getSingleResult();
			/*if ("gson".equals(dataResult)) {
				String json = new Gson().toJson(enseignant);
				result.put("data", json);*/
			/*} else {*/
				result.put("data", enseignant);
			/*}*/
			result.put("code", 1);
		} catch (Exception ex) {
			result.put("code", 2);
			result.put("massage", "error when finding all user");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}

	public HashMap<String, Object> findById(long id, String dataresult) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			Enseignant enseignant = em.find(Enseignant.class, id);
			if ("gson".equals(dataresult)) {
				String json = new Gson().toJson(enseignant);
				result.put("data", json);
			} else {
				result.put("data", enseignant);
			}
			result.put("code", 1);
		} catch (Exception ex) {
			result.put("code", 2);
			result.put("message", "error when finding Filiere by enseignant");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}

	public boolean addDefaultEnseignant() {
		try {
			Enseignant enseignant = new Enseignant();
			enseignant.setNom("administrateur");
			enseignant.setPrenom("administrateur");
			enseignant.setMatricule("admin");
			enseignant.setMotDePass("admin");
			enseignant.setEstAdmin(true);
			em.persist(enseignant);
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public int count(){
		int nbre=-1;
		try{
			nbre=((Long)em.createQuery("select count(e) from Enseignant as e").getSingleResult()).intValue();
		}catch(Exception ex){
			nbre=0;
		}
		return nbre;
	}
}