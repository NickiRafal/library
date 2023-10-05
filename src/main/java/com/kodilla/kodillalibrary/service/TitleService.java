package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService {

    private final TitleRepository titleRepository;

    @Autowired
    public TitleService(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    public Title addTitle(Title title) {
        return titleRepository.save(title);
    }

    public List<Title> getAllTitles() {
        return (List<Title>) titleRepository.findAll();
    }
}


