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
@Table(name = "PositionType")
public class PositionType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Идентификатор должности
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    /**
     * Название должности
     */
    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "positionId", fetch = FetchType.EAGER)
    private Set<Employee> employees = new HashSet<>();
}