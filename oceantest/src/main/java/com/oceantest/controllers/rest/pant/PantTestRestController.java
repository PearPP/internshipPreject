package com.oceantest.controllers.rest.pant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.oceantest.services.jpa.model.PantEntity;
import com.oceantest.services.pant.model.Pant;
import com.oceantest.services.pant.service.PantService;

@RestController
@RequestMapping(value = "/testPant")
public class PantTestRestController {

	@Autowired
	PantService pantService;

	@Autowired
	private com.oceantest.services.jpa.service.PantJpaService pantJpaService;

	// ------- create new pant list -------
	@RequestMapping(value = "/pant/", method = RequestMethod.POST)
	public ResponseEntity<Void> createNewPant(@RequestBody Pant pant, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating new pant brand " + pant.getBrand());
		if (pantService.isPantExist(pant)) {
			System.out.println("A pant with brand " + pant.getBrand() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		pantService.createPant(pant);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/pant/{id}").buildAndExpand(pant.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------- create new jpa pant list -------
	@RequestMapping(value = "/pant/jpa/", method = RequestMethod.POST)
	public ResponseEntity<Void> createNewJpaPant(@RequestBody PantEntity pant, UriComponentsBuilder ucBuilder) {
//		System.out.println("pant.getId() = "+pant.getId());
		pantJpaService.create(pant);
//		System.out.println("pant.getId() = "+pant.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/pant/jpa/{id}").buildAndExpand(pant.getPantId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------- get all pant -------
	@RequestMapping(value = "/pant/", method = RequestMethod.GET)
	public ResponseEntity<List<Pant>> showAllPant() {
		List<Pant> pants = pantService.findAllPant();
		System.out.println("get all pant");

		if (pants.isEmpty()) {
			System.out.println("There are no pant recoed");
			return new ResponseEntity<List<Pant>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Pant>>(pants, HttpStatus.OK);
	}

	// ------- get all jpa pants -------
	@RequestMapping(value = "/pant/jpa/", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PantEntity>> showAllJpaPant() throws Exception {
		List<PantEntity> pants = pantJpaService.findAll();
		System.out.println("get all pant");

		if (pants.isEmpty()) {
			System.out.println("There are no pant recoed");
			return new ResponseEntity<List<PantEntity>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PantEntity>>(pants, HttpStatus.OK);
	}

	// ------- get single pant -------
	@RequestMapping(value = "/pant/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pant> findById(@PathVariable("id") long id) {
		Pant pant = pantService.findById(id);
		System.out.println("get single pant with id, id = " + id);
		if (pant == null) {
			System.out.println("Pant with id " + id + " not found");
			return new ResponseEntity<Pant>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pant>(pant, HttpStatus.OK);
	}

	// ------- get jpa single pant -------
	@RequestMapping(value = "/pant/jpa/{id}", method = RequestMethod.GET)
	public ResponseEntity<PantEntity> findByJpaId(@PathVariable("id") long id) throws Exception {
		// Pant pant = pantService.findById(id);
		PantEntity pant = pantJpaService.findById(id);
		System.out.println("get single pant with id, id = " + id);
		if (pant == null) {
			System.out.println("Pant with id " + id + " not found");
			return new ResponseEntity<PantEntity>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PantEntity>(pant, HttpStatus.OK);
	}

	// ------- update pant -------
	@RequestMapping(value = "/pant/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Pant> updatePant(@PathVariable("id") long id, @RequestBody Pant pant) {
		System.out.println("Updating Pant id = " + id);
		Pant currentPant = pantService.findById(id);

		if (currentPant == null) {
			System.out.println("Pant with id " + id + " not found");
			return new ResponseEntity<Pant>(HttpStatus.NOT_FOUND);
		}

		currentPant.setBrand(pant.getBrand());
		currentPant.setTest(pant.getTest());
		currentPant.setPrice(pant.getPrice());
		
		pantService.updatePant(currentPant);
		return new ResponseEntity<Pant>(currentPant, HttpStatus.OK);
	}
	
	// ------- update jpa pant -------
	@RequestMapping(value = "/pant/jpa/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PantEntity> updateJpaPant(@PathVariable("id") long id, @RequestBody PantEntity pant) throws Exception {
		System.out.println("Updating Pant id = " + id);
		PantEntity currentPant = pantJpaService.findById(id);

		if (currentPant == null) {
			System.out.println("Pant with id " + id + " not found");
			return new ResponseEntity<PantEntity>(HttpStatus.NOT_FOUND);
		}

		currentPant.setPantBrand(pant.getPantBrand());
		currentPant.setPantTest(pant.getPantTest());
		currentPant.setPantPrice(pant.getPantPrice());
		
		pantJpaService.updatePant(currentPant);
		return new ResponseEntity<PantEntity>(currentPant, HttpStatus.OK);
	}
	
	// ------- Delete all pant ------
	@RequestMapping(value = "/pant/", method = RequestMethod.DELETE)
	public ResponseEntity<Pant> deleteAllPant() {
		System.out.println("Deleting All Pants");

		pantService.deleteAllPant();
		return new ResponseEntity<Pant>(HttpStatus.OK);
	}
	
//	// ------- Delete all jpa pant -------
//	@RequestMapping(value="/pant/jpa/", method = RequestMethod.DELETE)
//	public ResponseEntity<PantEntity> deleteAllJpaPant() {
//		System.out.println("Deleting All Pants");
//		pantJpaService.deleteAllPant();
//		return new  ResponseEntity<PantEntity>(HttpStatus.OK);
//	}

	// ------- Delete single pant -------
	@RequestMapping(value = "pant/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Pant> deleteSinglePant(@PathVariable("id") long id) {
		System.out.println("Delete single pant by id, id = " + id);

		Pant pant = pantService.findById(id);
		if (pant == null) {
			System.out.println("Unable to delete. Pant id = " + id + " is not found");
			return new ResponseEntity<Pant>(HttpStatus.NOT_FOUND);
		}

		pantService.deletePantById(id);
		return new ResponseEntity<Pant>(HttpStatus.OK);
	}

	// ------- Delete single jpa pant -------
	@RequestMapping(value = "pant/jpa/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PantEntity> deleteSingleJpaPant(@PathVariable("id") long id) throws Exception {
		System.out.println("Delete single pant by id, id = " + id);

		PantEntity pant = pantJpaService.findById(id);
		if (pant == null) {
			System.out.println("Unable to delete. Pant id = " + id + " is not found");
			return new ResponseEntity<PantEntity>(HttpStatus.NOT_FOUND);
		}

		pantJpaService.deletePantById(id);
		return new ResponseEntity<PantEntity>(HttpStatus.OK);
	}
}
