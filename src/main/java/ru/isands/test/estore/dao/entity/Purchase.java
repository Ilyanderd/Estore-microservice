package ru.isands.test.estore.dao.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "purchases")
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Идентификатор покупки
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "purchase_counter")
    @TableGenerator(name = "purchase_counter", pkColumnName = "name", pkColumnValue = "ru.isands.test.estore.dao.entity.Purchase", table = "counter", valueColumnName = "currentid", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Идентификатор товара
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "electro_id", nullable = false)
    private ElectroItem electroId;

    /**
     * Идентификатор сотрудника
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employeeId;

    /**
     * Идентификатор магазина
     */
    @Column(name = "shop_id", nullable = false)
    private Long shopId;

    /**
     * Дата совершения покупки
     */
    @Column(name = "purchase_date", nullable = false)
    private Date purchaseDate;

    /**
     * Способ оплаты
     */
    @Column(name = "type", nullable = false)
    private int type;
}