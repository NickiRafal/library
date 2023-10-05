package com.kodilla.kodillalibrary.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.kodilla.kodillalibrary.domain.BookCopy;
import com.kodilla.kodillalibrary.domain.Loan;
import com.kodilla.kodillalibrary.domain.Reader;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.service.BookCopyService;
import com.kodilla.kodillalibrary.service.LoanService;
import com.kodilla.kodillalibrary.service.ReaderService;
import com.kodilla.kodillalibrary.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/library")
public class LibraryController {

    private final ReaderService readerService;
    private final TitleService titleService;
    private final BookCopyService bookCopyService;
    private final LoanService loanService;

    @Autowired
    public LibraryController(
            ReaderService readerService,
            TitleService titleService,
            BookCopyService bookCopyService,
            LoanService loanService
    ) {
        this.readerService = readerService;
        this.titleService = titleService;
        this.bookCopyService = bookCopyService;
        this.loanService = loanService;
    }

    //  operacje na czytelnikach

    @PostMapping("/readers")
    public Reader addReader(@RequestBody Reader reader) {
        return readerService.addReader(reader);
    }

    @GetMapping("/readers")
    public List<Reader> getAllReaders() {
        return readerService.getAllReaders();
    }

    @DeleteMapping("/readers/{readerId}")
    public ResponseEntity<Void> deleteReader(@PathVariable Long readerId) {
        readerService.deleteById(readerId);
        return ResponseEntity.ok().build();
    }


// operacje na tytułach

    @PostMapping("/titles")
    public Title addTitle(@RequestBody Title title) {
        return titleService.addTitle(title);
    }

    @GetMapping("/titles")
    public List<Title> getAllTitles() {
        return titleService.getAllTitles();
    }

    //  operacje na egzemplarzach książek

    @PostMapping("/copies")
    public BookCopy addBookCopy(@RequestBody BookCopy copy) {
        return bookCopyService.addBookCopy(copy);
    }

    @GetMapping("/copies")
    public List<BookCopy> getAllBookCopies() {
        return (List<BookCopy>) bookCopyService.getAllBookCopies();
    }

    @GetMapping("/copies-count")
    @ResponseBody
    public List<Object[]> getCountTheNumberOfAvailableCopies(){
        return bookCopyService.getCountTheNumberOfAvailableCopies();

    }
    @PutMapping("/update-lean")
    public ResponseEntity<String> updateBookCopy(@RequestParam Long titleId) {
        boolean updated = bookCopyService.updateBookCopyStatus(titleId);

        if (updated) {
            return ResponseEntity.ok("Pomyślnie zaktualizowano status egzemplarza książki.");
        } else {
            return ResponseEntity.badRequest().body("Nie udało się zaktualizować statusu egzemplarza książki.");
        }
    }


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

