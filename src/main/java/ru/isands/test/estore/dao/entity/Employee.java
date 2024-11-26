package ru.isands.test.estore.dao.entity;


import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Идентификатор сотрудника
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_counter")
    @TableGenerator(name = "employee_counter", pkColumnName = "name", pkColumnValue = "ru.isands.test.estore.dao.entity.Employee", table = "counter", valueColumnName = "currentid", allocationSize = 2)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Фамилия сотрудника
     */
    @Column(name = "lastname", nullable = false, length = 100)
    private String lastName;

    /**
     * Имя сотрудника
     */
    @Column(name = "firstname", nullable = false, length = 100)
    private String firstName;

    /**
     * Отчество сотрудника
     */
    @Column(name = "patronymic", nullable = false, length = 100)
    private String patronymic;

    /**
     * Дата рождения сотрудника
     */
    @Column(name = "birthDate", nullable = false)
    private Date birthDate;

    /**
     * Ссылка на должность сотрудника
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", nullable = false)
    private PositionType positionId;

    /**
     * Ссылка на магазин, в котором работает сотрудник
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shopId;

    /**
     * Пол сотрудника (true - мужской, false - женский)
     */
    @Column(name = "gender", nullable = false)
    private boolean gender;

    /*@OneToMany
    private List<ElectroEmployee> electroEmployees;*/
}