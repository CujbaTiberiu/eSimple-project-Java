package com.eSimple.project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eSimple.project.Entity.GlbModel;
import com.eSimple.project.Service.GlbModelService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/glb")
public class GlbModelController {
	
	@Autowired
	GlbModelService dbs;
	
	@PostMapping
	public ResponseEntity<?> addGlbModel(@RequestBody GlbModel g){
		return ResponseEntity.ok(dbs.add(g));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GlbModel> update(@RequestBody GlbModel g ,@PathVariable Long id){
		return ResponseEntity.ok(dbs.update(g, id));
	}

	@GetMapping
	public ResponseEntity<List<GlbModel>> getAll(){
		return ResponseEntity.ok(dbs.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<GlbModel>> getById(@PathVariable Long id){
		return ResponseEntity.ok(dbs.getById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return ResponseEntity.ok(dbs.delete(id));
	}
}
