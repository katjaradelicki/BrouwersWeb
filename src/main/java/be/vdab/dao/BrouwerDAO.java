package be.vdab.dao;



import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Brouwer;

public interface BrouwerDAO extends JpaRepository<Brouwer, Long>{
	Collection<Brouwer> findByNaamStartingWith(String beginNaam);
	Collection<Brouwer> findBrouwerMetHoogsteOmzet();
}  
