package ru.isands.test.estore.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PurchaseType")
@NoArgsConstructor
public class PurchaseType implements Serializable {

    private static final long serialVersionUID = 1L;

    public PurchaseType(long id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Идентификатор типа покупки
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Наименование типа покупки
     */
    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
    private Set<Purchase> purchases = new HashSet<>();
}