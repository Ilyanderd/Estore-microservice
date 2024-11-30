package ru.isands.test.estore.dao.entity;


import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "employees")
@NoArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    public Employee(long id, String lastName, String firstName, String patronymic, Date birthDate, long positionId, long shopId, boolean gender) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.positionId = positionId;
        this.shopId = shopId;
        this.gender = gender;
    }

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
    @Column(name = "position_id", nullable = false)
    private Long positionId;

    /**
     * Ссылка на магазин, в котором работает сотрудник
     */
    @Column(name = "shop_id", nullable = false)
    private Long shopId;

    /**
     * Пол сотрудника (true - мужской, false - женский)
     */
    @Column(name = "gender", nullable = false)
    private boolean gender;

    @JsonIgnore
    @OneToMany(mappedBy = "employeeId", fetch = FetchType.EAGER)
    private Set<Purchase> purchases = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "electro_employee",
            joinColumns = @JoinColumn(name = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "electroTypeId")
    )
    private Set<ElectroType> electroTypes = new HashSet<>();
}