package it.uniroma3.repository;

import java.util.List;

import it.uniroma3.model.Responsabile;

public interface ResponsabileRepository {
	public Responsabile save(Responsabile responsabile);
	public Responsabile findByPrimaryKey(Long id);
	public List<Responsabile> findAll();
	public void delete(Responsabile responsabile);
	public void update(Responsabile responsabile);
}
