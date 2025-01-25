package com.ambro.space.hibernate.enitity;

import jakarta.persistence.*;

import java.lang.reflect.Member;
import java.util.Date;

@Entity
@Table(name = "library_cards")
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "library_card_seq")
    @SequenceGenerator(name = "library_card_seq", initialValue = 1)
    Long libraryCardId;

    @Temporal(value = TemporalType.DATE)
    Date issueDate;

    @OneToOne(mappedBy = "libraryCard")
    Member member;

    public Long getLibraryCardId() {
        return libraryCardId;
    }

    public void setLibraryCardId(Long libraryCardId) {
        this.libraryCardId = libraryCardId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
