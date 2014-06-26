package be.vdab.services;

import java.util.Collection;

import be.vdab.entities.Brouwer;

public interface BrouwerService {
	public void create(Brouwer brouwer);
	public Collection<Brouwer> findAll();
	public Collection<Brouwer> findByNaam(String beginNaam);
	public Collection<Brouwer> findBrouwerMetHoogsteOmzet();
}
