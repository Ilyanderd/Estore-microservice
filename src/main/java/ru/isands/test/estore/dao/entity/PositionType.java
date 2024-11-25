package ru.isands.test.estore.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "PositionType")
public class PositionType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Идентификатор должности
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    /**
     * Название должности
     */
    @Column(name = "title", unique = true, nullable = false, length = 150)
    private String title;
}
