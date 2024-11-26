package ru.isands.test.estore.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "shops")
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Идентификатор магазина
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    /**
     * Название магазина
     */
    @Column(name = "title", nullable = false, length = 150)
    private String title;

    /**
     * Адресс магазина
     */
    @Column(name = "address", nullable = false)
    private String address;
}
