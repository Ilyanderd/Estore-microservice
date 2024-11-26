package ru.isands.test.estore.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "ElectroItem")
public class ElectroItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Идентификатор товара
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    /**
     * Название товара
     */
    @Column(name = "title", unique = true, nullable = false, length = 150)
    private String title;

    /**
     * Тип товара
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "etype_id", nullable = false)
    private ElectroType electroType;

    /**
     * Цена товара в рублях
     */
    @Column(name = "price_in_rubles", nullable = false)
    private long priceInRubles;

    /**
     * Количество товара
     */
    @Column(name = "count", nullable = false)
    private long count;

    /**
     * Признак архивности товара (true – товара нет в наличии, снят с продаж, false – товар в продаже)
     */
    @Column(name = "inStock", nullable = false)
    private boolean inStock;

    /**
     * Описание товара
     */
    @Column(name = "description", nullable = false)
    private String description;
}
