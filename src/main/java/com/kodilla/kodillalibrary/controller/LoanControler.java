package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.Loan;
import com.kodilla.kodillalibrary.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class LoanControler {

    private LoanService loanService;

    //  operacje na wypożyczeniach

    @PostMapping("/loans")
    public Loan addLoan(@RequestBody Loan loan) {
        return loanService.addLoan(loan);
    }

    @GetMapping("/loans")
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/loan-details")
    @ResponseBody
    public List<Object[]> getLoanDetails() {
        return loanService.getLoanDetails();
    }
}
