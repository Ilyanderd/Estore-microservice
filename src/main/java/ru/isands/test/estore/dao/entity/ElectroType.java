package ru.isands.test.estore.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

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

    /*@OneToMany
    private List<ElectroEmployee> electroEmployees;*/
}
