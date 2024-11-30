package ru.isands.test.estore.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "purchases")
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "electro_id", nullable = false)
    private Long electroId;

    /**
     * Идентификатор сотрудника
     */
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

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
    private Long type;
}