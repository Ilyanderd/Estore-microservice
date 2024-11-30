package ru.isands.test.estore.service;

import org.springframework.data.domain.Page;
import ru.isands.test.estore.dao.entity.Purchase;

import java.util.List;

public interface PurchaseService {

    Page<Purchase> getPurchases(int page, int size);

    List<Purchase> getPurchases();

    Purchase getPurchase(long id);

    void addPurchase(Purchase purchase);

    void updatePurchase(Purchase purchase);

    void deletePurchase(long id);
}