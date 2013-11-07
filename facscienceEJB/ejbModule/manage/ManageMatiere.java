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
import entity.Examen;
import entity.Matiere;

/**
 * Session Bean implementation class ManageMatiere
 */
@Stateless
public class ManageMatiere implements ManageMatiereRemote {

	/**
	 * Default constructor.
	 */
	public ManageMatiere() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager em;

	public Map<String, Object> create(String code, String intitule, int credit,
			String matricule) {

		HashMap<String, Object> result = new HashMap<String, Object>();
		Collection<Examen> examens = new ArrayList<Examen>();

		Query query = em
				.createQuery("select object(e) from Enseignant as e where e.matricule = :matricule");
		query.setParameter("matricule", matricule);
		Enseignant enseignant = (Enseignant) query.getSingleResult();
		System.out.println(enseignant.getNom());
		Matiere matiere = new Matiere();

		try {
			matiere.setCode(code);
			matiere.setIntitule(intitule);
			matiere.setExamens(examens);
			matiere.setEnseignant(enseignant);
			matiere.setCredit(credit);
			em.persist(matiere);
			result.put("code", 1);
		} catch (Exception ex) {
			result.put("code", 1);
			result.put("message", "Error when create matiere");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}

	public Map<String, Object> edit(Matiere matiere) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		try {
			em.getTransaction().begin();
			em.merge(matiere);
			result.put("code", 1);
			em.getTransaction().commit();
		} catch (Exception ex) {
			result.put("code", 2);
			result.put("message", "error when editing a matiere");
			result.put("errormessage", ex.getMessage());
			em.getTransaction().rollback();
		}
		return result;
	}

	public HashMap<String, Object> destroy(String code) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			em.getTransaction().begin();
			Matiere matiere = em.find(Matiere.class, code);
			em.remove(matiere);
			result.put("code", 1);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			result.put("code", 2);
			result.put("message", "error when destroy a matiere");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}

	public HashMap<String, Object> findByCode(String code) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			Matiere matiere = em.find(Matiere.class, code);
			
				result.put("data", matiere);
			
			result.put("code", 1);
		} catch (Exception ex) {
			result.put("code", 2);
			result.put("message", "error when finding Matiere by code");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}

	public HashMap<String, Object> findByIntitule(String intitule,
			String dataresult) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			Query query = em
					.createQuery("select object(o) from Matiere as o where o.intitule= :intitule");
			query.setParameter("intitule", intitule);
			Matiere matiere = (Matiere) query.getSingleResult();
			if ("gson".equals(dataresult)) {
				String json = new Gson().toJson(matiere);
				result.put("data", json);
			} else {
				result.put("data", matiere);
			}
			result.put("code", 1);
		} catch (Exception ex) {
			result.put("code", 2);
			result.put("message", "error when finding Matiere by intitule");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}

	public HashMap<String, Object> count() {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			int nbre = ((Long) em.createQuery(
					"select count(o) from Matiere as o").getSingleResult())
					.intValue();
			result.put("code", 1);
			result.put("data", nbre);
		} catch (Exception Ex) {
			result.put("code", 2);
			result.put("message", "error when counting Matiere");
		}
		return result;
	}

	public HashMap<String, Object> findAll() {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			@SuppressWarnings("unchecked")
			List<Matiere> matieres = em.createQuery(
					"select object(e) from Matiere as e").getResultList();

			result.put("data", matieres);

			result.put("code", 1);
		} catch (Exception ex) {
			result.put("code", 2);
			result.put("message", "error when finding Matiere");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}
}