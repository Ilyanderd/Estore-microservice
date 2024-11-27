package ru.isands.test.estore.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
     * Наименование типа покупки
     */
    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
    private Set<Purchase> purchases = new HashSet<>();
}