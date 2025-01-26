package com.ambro.space.hibernate.enitity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(generator = "loan_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "loan_seq", initialValue = 1)
    Long loanId;
    @Column(name = "loan_date", nullable = false)
    @Temporal(value = TemporalType.DATE)
    Date loanDate;

    @Temporal(value = TemporalType.DATE)
    Date retunDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getRetunDate() {
        return retunDate;
    }

    public void setRetunDate(Date retunDate) {
        this.retunDate = retunDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
