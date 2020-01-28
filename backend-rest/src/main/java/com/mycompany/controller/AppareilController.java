package com.mycompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.model.Appareil;
import com.mycompany.service.AppareilService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/appareils")
public class AppareilController {

	@Autowired
	private AppareilService appareilService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Appareil> getAppareils() {
		return appareilService.getAppareilsList();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody Appareil getAppareil(@PathVariable Long id) {
		return appareilService.getAppareilById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody Appareil appareil) {
		appareilService.add(appareil);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateAppareils(@RequestBody List<Appareil> appareils) {
		appareilService.updateAppareils(appareils);
	}
}
