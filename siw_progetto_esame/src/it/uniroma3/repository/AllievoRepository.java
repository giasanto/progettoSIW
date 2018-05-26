package it.uniroma3.repository;

import java.util.List;

import it.uniroma3.model.Allievo;

public interface AllievoRepository {
	public Allievo save(Allievo allievo);
	public Allievo findByPrimaryKey(Long id);
	public List<Allievo> findAll();
	public void delete(Allievo allievo);
	public void update(Allievo allievo);
}
