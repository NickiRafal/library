package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.BookCopy;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.service.BookCopyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class BodyCopyControler {

    private BookCopyService bookCopyService;

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
    public List<Title> getCountTheNumberOfAvailableCopies(){
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
}
