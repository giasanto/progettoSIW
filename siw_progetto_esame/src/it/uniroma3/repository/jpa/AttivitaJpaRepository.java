package it.uniroma3.repository.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import it.uniroma3.model.Attivita;
import it.uniroma3.repository.AttivitaRepository;

public class AttivitaJpaRepository implements AttivitaRepository {

	EntityManager em;
	
	@Override
	public Attivita save(Attivita attivita) {
		if(attivita.getId()==null) {
			em.persist(attivita);
		} else {
			Attivita attivita2= findByPrimaryKey(attivita.getId());
			if(attivita2==null) {
				em.persist(attivita);
			} else {
				em.merge(attivita);
			}
		}
		return attivita;
	}

	@Override
	public Attivita findByPrimaryKey(Long id) {
		return em.find(Attivita.class, id);
	}

	@Override
	public List<Attivita> findAll() {
		return em.createNamedQuery("SELECT * FROM Attivita", Attivita.class).getResultList();
	}

	@Override
	public void delete(Attivita attivita) {
		em.remove(attivita);		
	}

	@Override
	public void update(Attivita attivita) {
		em.merge(attivita);
	}
}



