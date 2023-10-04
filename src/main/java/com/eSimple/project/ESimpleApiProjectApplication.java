package com.eSimple.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eSimple.project.Entity.GlbModel;
import com.eSimple.project.Entity.Pinpoint;
import com.eSimple.project.Service.GlbModelService;

@SpringBootApplication
public class ESimpleApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ESimpleApiProjectApplication.class, args);
	}
	
}
