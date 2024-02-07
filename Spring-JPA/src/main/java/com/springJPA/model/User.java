package com.springJPA.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="userData")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String firstName;
    private String lastName;
}
