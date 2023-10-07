package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.service.TitleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class TitleControler {
    // operacje na tytułach
private TitleService titleService;
    @PostMapping("/titles")
    public Title addTitle(@RequestBody Title title) {
        return titleService.addTitle(title);
    }

    @GetMapping("/titles")
    public List<Title> getAllTitles() {
        return titleService.getAllTitles();
    }

}
