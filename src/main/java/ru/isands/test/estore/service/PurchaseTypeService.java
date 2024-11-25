package ru.isands.test.estore.service;

import ru.isands.test.estore.dao.entity.PurchaseType;

import java.util.List;

public interface PurchaseTypeService {
    List<PurchaseType> getPurchaseTypes();

    PurchaseType getPurchaseType(long id);

    void addPurchaseType(PurchaseType purchaseType);

    void updatePurchaseType(PurchaseType purchaseType);

    void deletePurchaseType(long id);
}
