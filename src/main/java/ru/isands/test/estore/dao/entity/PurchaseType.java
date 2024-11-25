package ru.isands.test.estore.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "PurchaseType")
public class PurchaseType implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Идентификатор типа покупки
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    /**
     *  Наименование типа покупки
     */
    @Column(name = "title", nullable = false, length = 150)
    private String title;
}
