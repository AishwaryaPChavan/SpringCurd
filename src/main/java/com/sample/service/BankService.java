package com.sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.BankProjectApplication;
import com.sample.Entity.Bank;
import com.sample.repository.BankRepository;

@Service
public class BankService {

    private final BankProjectApplication bankProjectApplication;
	
	@Autowired
	private BankRepository repository;

    BankService(BankProjectApplication bankProjectApplication) {
        this.bankProjectApplication = bankProjectApplication;
    } 
	
	public Bank saveAccount(Bank b) {
		Bank b1=repository.save(b);
		return b1;
		
	}

	
	public List<Bank> getAllAccounts() {
	    return repository.findAll();
	}

	
	public void deleteAcc(int id) {
		repository.deleteById(id);
	}
	
	public Bank updateacc(int id,Bank nb) {
		
		Optional<Bank> temp=repository.findById(id);
		if(temp.isPresent()) {
			Bank ob=temp.get();
			ob.setAcc_type(nb.getAcc_type());
			ob.setBname(nb.getBname());
			ob.setBalance(nb.getBalance());
			return repository.save(ob);
			
		}else {
		     
			throw new RuntimeException("No Account FOUND");
		}

		
		
		
		
		
	}

}
