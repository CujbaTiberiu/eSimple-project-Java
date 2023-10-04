package com.eSimple.project.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pinpoints")
public class Pinpoint {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	 	@Column(nullable = false)
	 	private String name;
	 	
	 	//@ElementCollection
	 	@Column(nullable = false)
	    private List<Double> position;
	 	
	 	@Column(nullable = false)
	 	private String link;
	 	
	 	@JsonIgnore
	 	@ManyToOne
	    @JoinColumn(name = "glbModel_id")
	    private GlbModel glbModel;
	

}
