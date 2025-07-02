package com.sample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.Entity.Bank;
import com.sample.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	private BankService service;
	
	@PostMapping("/insert")
	public ResponseEntity<Bank> saveAcc(@RequestBody Bank b) {
		Bank b1 =  service.saveAccount(b);
		return ResponseEntity.ok(b1);
		
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<List<Bank>> fetchAll() {
	    List<Bank> list = service.getAllAccounts();
	    return ResponseEntity.ok(list);
	}

	@DeleteMapping("/delete/{aid}")
	public void delete(@PathVariable int aid) {
		service.deleteAcc(aid);
	}
	
	@PutMapping("/update/{bid}")
	public Bank update(@PathVariable int bid,@RequestBody Bank nb) {
		
		Bank b1=service.updateacc(bid, nb);
		return b1;
	}
	

}
