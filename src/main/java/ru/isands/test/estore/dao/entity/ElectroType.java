package ru.isands.test.estore.dao.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Electro_type")
public class ElectroType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Идентификатор типа электроники
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    /**
     * Название типа электроники
     */
    @Column(name = "title", unique = true, nullable = false, length = 150)
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "electroType", fetch = FetchType.EAGER)
    private Set<ElectroItem> electroItems = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "electroTypes", fetch = FetchType.EAGER)
    private Set<Employee> employees = new HashSet<>();
}