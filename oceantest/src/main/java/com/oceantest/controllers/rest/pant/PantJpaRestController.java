package com.oceantest.controllers.rest.pant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.oceantest.services.jpa.model.PantEntity;

@RestController
@RequestMapping(value = "/Pant")
public class PantJpaRestController {
	
	@Autowired
	private com.oceantest.services.jpa.service.PantJpaService pantService;
	
	// ------- create new pant -------
		@RequestMapping(value = "/pant/jpa/", method = RequestMethod.POST)
		public ResponseEntity<Void> createNewJpaPant(@RequestBody PantEntity pant, UriComponentsBuilder ucBuilder) {
//			System.out.println("pant.getId() = "+pant.getId());
			pantService.create(pant);
//			System.out.println("pant.getId() = "+pant.getId());
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/pant/jpa/{id}").buildAndExpand(pant.getPantId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
		// ------- get all pants -------
		@RequestMapping(value = "/pant/jpa/", method = RequestMethod.GET)
		public ResponseEntity<List<PantEntity>> showAllJpaPant() throws Exception {
			List<PantEntity> pants = pantService.findAll();
			System.out.println("get all pant");

			if (pants.isEmpty()) {
				System.out.println("There are no pant recoed");
				return new ResponseEntity<List<PantEntity>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<PantEntity>>(pants, HttpStatus.OK);
		}
		
		

		// ------- get single pant by id -------
		@RequestMapping(value = "/pant/jpa/{id}", method = RequestMethod.GET)
		public ResponseEntity<PantEntity> findByJpaId(@PathVariable("id") long id) throws Exception {
			// Pant pant = pantService.findById(id);
			PantEntity pant = pantService.findById(id);
			System.out.println("get single pant with id, id = " + id);
			if (pant == null) {
				System.out.println("Pant with id " + id + " not found");
				return new ResponseEntity<PantEntity>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<PantEntity>(pant, HttpStatus.OK);
		}
		
		// ------- update pant -------
		@RequestMapping(value = "/pant/jpa/{id}", method = RequestMethod.PUT)
		public ResponseEntity<PantEntity> updateJpaPant(@PathVariable("id") long id, @RequestBody PantEntity pant) throws Exception {
			System.out.println("Updating Pant id = " + id);
			PantEntity currentPant = pantService.findById(id);

			if (currentPant == null) {
				System.out.println("Pant with id " + id + " not found");
				return new ResponseEntity<PantEntity>(HttpStatus.NOT_FOUND);
			}

			currentPant.setPantBrand(pant.getPantBrand());
			currentPant.setPantTest(pant.getPantTest());
			currentPant.setPantPrice(pant.getPantPrice());
			
			pantService.updatePant(currentPant);
			return new ResponseEntity<PantEntity>(currentPant, HttpStatus.OK);
		}
		

		// ------- Delete single pant -------
		@RequestMapping(value = "pant/jpa/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<PantEntity> deleteSingleJpaPant(@PathVariable("id") long id) throws Exception {
			System.out.println("Delete single pant by id, id = " + id);

			PantEntity pant = pantService.findById(id);
			if (pant == null) {
				System.out.println("Unable to delete. Pant id = " + id + " is not found");
				return new ResponseEntity<PantEntity>(HttpStatus.NOT_FOUND);
			}

			pantService.deletePantById(id);
			return new ResponseEntity<PantEntity>(HttpStatus.OK);
		}
}
