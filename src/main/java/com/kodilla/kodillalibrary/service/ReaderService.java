package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.Reader;
import com.kodilla.kodillalibrary.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;

    @Autowired
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public Reader addReader(Reader reader) {
        return readerRepository.save(reader);
    }
    public void deleteById(Long longReaderId){
        readerRepository.deleteById(longReaderId);
    }

    public List<Reader> getAllReaders() {
        return (List<Reader>) readerRepository.findAll();
    }


}