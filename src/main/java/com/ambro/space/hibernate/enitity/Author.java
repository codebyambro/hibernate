package com.ambro.space.hibernate.enitity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "author_seq")
    @SequenceGenerator(name = "author_seq", initialValue = 1)
    @Column(name = "author_id")
    Long authorId;

    @Column(name = "author_name", nullable = false)
    String name;

    @Column(name = "author_dob")
    @Temporal(TemporalType.DATE)
    Date author_dob;

    @Column(name = "author_dod")
    @Temporal(TemporalType.DATE)
    Date author_dod;

    @ManyToMany(mappedBy = "authors")
    Set<Book> books = new HashSet<>();

    @Column(name = "biography", nullable = true)
    String biography;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAuthor_dob() {
        return author_dob;
    }

    public void setAuthor_dob(Date author_dob) {
        this.author_dob = author_dob;
    }

    public Date getAuthor_dod() {
        return author_dod;
    }

    public void setAuthor_dod(Date author_dod) {
        this.author_dod = author_dod;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Author(Long authorId, String name, Date author_dob, Date author_dod, Set<Book> books, String biography) {
        this.authorId = authorId;
        this.name = name;
        this.author_dob = author_dob;
        this.author_dod = author_dod;
        this.books = books;
        this.biography = biography;
    }
}
