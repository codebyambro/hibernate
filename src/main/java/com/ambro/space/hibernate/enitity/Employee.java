package com.ambro.space.hibernate.enitity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee", schema = "movies")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private long salary;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public Employee(int id, String name, String email, long salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }
}
