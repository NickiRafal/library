package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.Loan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface LoanRepository extends CrudRepository <Loan , Long>{

    List<Loan> findAll();

    @Query(value = "SELECT reader.id AS User_Id, reader.first_name AS reader_first_name, reader.last_name AS reader_last_name, t.title, copy.id AS id_dostepnosci, copy.status " +
            "FROM Loan AS loan " +
            "JOIN book_copy AS copy ON loan.copy_id = copy.id " +
            "JOIN Reader AS reader ON loan.reader_id = reader.id " +
            "JOIN title t on t.id = copy.title_id", nativeQuery = true)
    List<Object[]> getLoanDetails() ;



}
