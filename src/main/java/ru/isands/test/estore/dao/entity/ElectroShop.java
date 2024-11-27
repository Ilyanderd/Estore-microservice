package ru.isands.test.estore.dao.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@IdClass(ElectroShopPK.class)
@Table(name = "store_eshop")
public class ElectroShop {
    /**
     * Идентификатор магазина
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shopId;

    /**
     * Идентификатор электротовара
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "electro_item_id")
    private ElectroItem electroItemId;

    /**
     * Оставшееся количество
     */
    @Column(name = "count", nullable = false)
    private int count;
}
