package com.ambro.space.hibernate.enitity;

import jakarta.persistence.*;

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "member_seq")
    @SequenceGenerator(name = "member_seq", initialValue = 1)
    Long memberId;

    @Column(name = "name", nullable = false)
    String name;

    @Column(nullable = true, name = "address")
    String address;

    @Column(nullable = false, name = "contact")
    long contact;

    @Column(nullable = false, name = "email")
    String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "cardId")
    LibraryCard libraryCard;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    Loan loan;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
