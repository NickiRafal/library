package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "copy_id")
    private BookCopy copy;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;
    @Column(name = "loan_date")
    @Temporal(TemporalType.DATE)
    private Date loanDate;
    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    private Date returnDate;

}
