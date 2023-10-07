package com.kodilla.kodillalibrary.controller;
import com.kodilla.kodillalibrary.domain.Reader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.kodilla.kodillalibrary.service.ReaderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class ReaderControler {


    private final ReaderService readerService;

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

}
