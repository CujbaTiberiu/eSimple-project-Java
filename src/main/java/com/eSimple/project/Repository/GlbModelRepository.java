package com.eSimple.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eSimple.project.Entity.GlbModel;

public interface GlbModelRepository extends JpaRepository<GlbModel, Long>{
	
	public boolean existsByModel(String model);

}
