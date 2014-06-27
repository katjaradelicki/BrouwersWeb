package be.vdab.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.BrouwerDAO;
import be.vdab.entities.Brouwer;

@Transactional(readOnly=true)//,isolation=Isolation.READ_COMMITTED) JPA ondersteunt geen isolation levels
@Service
public class BrouwerServiceImpl implements BrouwerService {
	
	private BrouwerDAO brouwerDAO;
	
	@Autowired
	public BrouwerServiceImpl(BrouwerDAO brouwerDAO){
		this.brouwerDAO=brouwerDAO;
	}

	@Override
	@Transactional(readOnly=false)
	@PreAuthorize("hasRole('administrator')")
	public void create(Brouwer brouwer) {
		brouwerDAO.save(brouwer);
		
	}

	@Override
	public Collection<Brouwer> findAll() {
		
		return brouwerDAO.findAll(new Sort("naam"));
	}

	@Override
	public Collection<Brouwer> findByNaam(String beginNaam) {
		
		return brouwerDAO.findByNaamStartingWith(beginNaam);
	}
	
	
	@Override
	public Collection<Brouwer> findBrouwerMetHoogsteOmzet() {
		
		return brouwerDAO.findBrouwerMetHoogsteOmzet();
	}
	
	

}
