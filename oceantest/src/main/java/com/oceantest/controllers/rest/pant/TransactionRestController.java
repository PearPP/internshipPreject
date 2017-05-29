package com.oceantest.controllers.rest.pant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.oceantest.services.jpa.model.TransactionEntity;

@RestController
@RequestMapping(value = "/Transaction")
public class TransactionRestController {
	@Autowired
	private com.oceantest.services.jpa.service.TransactionService transService;

	// -------- find all transaction -------
	@RequestMapping(value = "/trans/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionEntity>> showAllTransaction() throws Exception {
		List<TransactionEntity> trans = transService.findTransactionAll();
		System.out.println("get all transaction");
		return new ResponseEntity<List<TransactionEntity>>(trans, HttpStatus.OK);
	}

	// ------- create transaction -------
	@RequestMapping(value = "/trans/", method = RequestMethod.POST)
	public ResponseEntity<Void> createTransaction(@RequestBody TransactionEntity tran, UriComponentsBuilder ucBuilder) {
		transService.create(tran);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/trans/{id}").buildAndExpand(tran.getTransId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

}
