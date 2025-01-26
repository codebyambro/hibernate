package com.ambro.space.hibernate.enitity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "publisher_seq")
    @SequenceGenerator(name = "publisher_seq", initialValue = 1)
    Long publisherId;

    @Column(nullable = false, name = "publisher_name")
    String publisherName;

    @Column(nullable = false, name = "publisher_address")
    String publisherAddress;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher")
    Set<Book> books = new HashSet<>();

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
