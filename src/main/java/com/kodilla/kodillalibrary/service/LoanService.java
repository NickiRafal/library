package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.Loan;
import com.kodilla.kodillalibrary.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan addLoan(final Loan loan) {
        return loanRepository.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }


    public List<Object[]> getLoanDetails() {
        return loanRepository.getLoanDetails();
    }

}



