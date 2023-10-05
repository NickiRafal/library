package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.BookCopy;
import com.kodilla.kodillalibrary.repository.BookCopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyService {

    private final BookCopyRepository bookCopyRepository;

    @Autowired
    public BookCopyService(BookCopyRepository bookCopyRepository) {
        this.bookCopyRepository = bookCopyRepository;
    }

    public BookCopy addBookCopy(final BookCopy copy) {
        return bookCopyRepository.save(copy);
    }

    public Iterable<BookCopy> getAllBookCopies() {
        return bookCopyRepository.findAll();
    }
    public List<Object[]> getCountTheNumberOfAvailableCopies(){
        return bookCopyRepository.getCountTheNumberOfAvailableCopies();
    }
    public boolean updateBookCopyStatus(Long titleId) {
        int updatedRows = bookCopyRepository.updateStatusByTitleIdAndStatus(titleId);

        return updatedRows > 0;
    }


}
