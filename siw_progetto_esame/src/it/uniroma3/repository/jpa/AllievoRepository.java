package it.uniroma3.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.model.Allievo;

public class AllievoRepository implements it.uniroma3.repository.AllievoRepository {

	EntityManager em;
	
	@Override
	public Allievo save(Allievo allievo) {
		if(allievo.getId()==null) {
			em.persist(allievo);	
		} else {
			Allievo allievo2= findByPrimaryKey(allievo.getId());
			if(allievo2==null) {
				em.persist(allievo);
			} else {
				em.merge(allievo);
			}
		} 
		return allievo;
	}

	@Override
	public Allievo findByPrimaryKey(Long id) {
		return em.find(Allievo.class, id);
	}

	@Override
	public List<Allievo> findAll() {
		return em.createNamedQuery("SELECT * FROM Allievo", Allievo.class).getResultList();
	}

	@Override
	public void delete(Allievo allievo) {
		em.remove(allievo);
	}

	@Override
	public void update(Allievo allievo) {
		em.merge(allievo);
	}

}
