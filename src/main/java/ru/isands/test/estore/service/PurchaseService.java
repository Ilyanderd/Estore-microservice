package ru.isands.test.estore.service;

import ru.isands.test.estore.dao.entity.Purchase;

import java.util.List;

public interface PurchaseService {

    List<Purchase> getPurchases();

    Purchase getPurchase(long id);

    void addPurchase(Purchase purchase);

    void updatePurchase(Purchase purchase);

    void deletePurchase(long id);
}
