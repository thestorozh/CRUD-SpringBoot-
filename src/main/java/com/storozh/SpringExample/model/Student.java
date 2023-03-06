package com.storozh.SpringExample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Builder(toBuilder = true)
@AllArgsConstructor
@Data
@Entity
@Table(name = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "middlename")
    private String middlename;

    public Student() {
        // default constructor
    }

    public Student(String firstname, String lastname, String middlename) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
    }
}