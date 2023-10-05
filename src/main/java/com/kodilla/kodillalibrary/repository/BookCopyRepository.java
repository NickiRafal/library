package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.BookCopy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookCopyRepository extends CrudRepository <BookCopy,Long>{
    @Query(value = "SELECT bc.title_id, t.title, COUNT(bc.title_id) AS copiesCount " +
            "FROM book_copy AS bc " +
            "JOIN title AS t ON bc.title_id = t.id " +
            "WHERE bc.status = 'dostępna'" +
            "GROUP BY bc.title_id, t.title", nativeQuery = true)
    List<Object[]> getCountTheNumberOfAvailableCopies() ;


    @Transactional
    @Modifying
    @Query(value = "UPDATE book_copy SET status = 'wypozyczona' " +
            "WHERE title_id = :titleId AND status = 'dostępna' LIMIT 1", nativeQuery = true)
    int updateStatusByTitleIdAndStatus(@Param("titleId") Long titleId);


}
