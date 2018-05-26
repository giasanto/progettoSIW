package it.uniroma3.repository.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import it.uniroma3.model.Responsabile;
import it.uniroma3.repository.ResponsabileRepository;

public class ResponsabileJpaRepository implements ResponsabileRepository{
	
	EntityManager em;

	@Override
	public Responsabile save(Responsabile responsabile) {
		if(responsabile.getId()==null) {
			em.persist(responsabile);
		} else {
			Responsabile responsabile2= findByPrimaryKey(responsabile.getId());
			if(responsabile2==null) {
				em.persist(responsabile);
			} else {
				em.merge(responsabile);
			}
		}
		return responsabile;
	}

	@Override
	public Responsabile findByPrimaryKey(Long id) {
		return em.find(Responsabile.class, id);
	}

	@Override
	public List<Responsabile> findAll() {
		return em.createNamedQuery("SELECT * FROM Responsabile", Responsabile.class).getResultList();
	}

	@Override
	public void delete(Responsabile responsabile) {
		em.remove(responsabile);		
	}

	@Override
	public void update(Responsabile responsabile) {
		em.merge(responsabile);
	}
}