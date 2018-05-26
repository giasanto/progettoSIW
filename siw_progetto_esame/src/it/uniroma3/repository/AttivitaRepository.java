package it.uniroma3.repository;

import java.util.List;

import it.uniroma3.model.Attivita;

public interface AttivitaRepository {
	public Attivita save(Attivita attivita);
	public Attivita findByPrimaryKey(Long id);
	public List<Attivita> findAll();
	public void delete(Attivita attivita);
	public void update(Attivita attivita);
}
