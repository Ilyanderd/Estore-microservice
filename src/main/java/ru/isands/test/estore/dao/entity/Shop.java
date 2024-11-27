package ru.isands.test.estore.dao.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
    @Column(name = "id", nullable = false)
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

    @JsonIgnore
    @OneToMany(mappedBy = "shopId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Employee> employees = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "shopId", fetch = FetchType.EAGER)
    private Set<Purchase> purchases = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "shopId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<ElectroShop> electroShops = new HashSet<>();
}