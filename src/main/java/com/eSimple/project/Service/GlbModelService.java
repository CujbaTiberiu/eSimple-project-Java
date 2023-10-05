package com.eSimple.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eSimple.project.Entity.GlbModel;
import com.eSimple.project.Entity.Pinpoint;
import com.eSimple.project.Repository.GlbModelRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GlbModelService {

	@Autowired
	GlbModelRepository db;
	
	public GlbModel add(GlbModel g) {
		if(db.existsByModel(g.getModel())) {
			throw new EntityExistsException("Model already exists in DataBase!");
		}
		 for (Pinpoint pinpoint : g.getPinpoints()) {
		        pinpoint.setGlbModel(g);
		    }
		db.save(g);
		return g;
		
	}
	
	public GlbModel update(GlbModel glb, Long id) {
		Optional<GlbModel> retrievedGlb = db.findById(id);
		

		if (retrievedGlb.isPresent()) {
			GlbModel glbUpdate = retrievedGlb.get();
			glbUpdate.setModel(glb.getModel());
			glbUpdate.setPinpoints(glb.getPinpoints());
			for (Pinpoint pinpoint : glb.getPinpoints()) {
		        pinpoint.setGlbModel(glbUpdate);
		    }
			db.save(glbUpdate);
			return glbUpdate;
		} else {
			throw new EntityExistsException("Unable to update Glb file!");
		}
	}
		
	
	public String delete(Long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("Model doesn't exist in DataBase by Id: " + id);
		}
		db.deleteById(id);
		return("Glb deleted successfully form Database!");
	}
	
	public Optional<GlbModel> getById(Long id) {
		if(!db.existsById(id)) {
			throw new EntityNotFoundException("Model doesn't exist in DataBase by Id: " + id);
		}
		return db.findById(id);
	}
	
	public List<GlbModel> getAll(){
		return db.findAll();
	}
	

}
