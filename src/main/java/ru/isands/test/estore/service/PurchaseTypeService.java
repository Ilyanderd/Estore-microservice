package ru.isands.test.estore.service;

import org.springframework.data.domain.Page;
import ru.isands.test.estore.dao.entity.PurchaseType;

import java.util.List;

public interface PurchaseTypeService {

    Page<PurchaseType> getPurchaseTypes(int page, int size);

    List<PurchaseType> getPurchaseTypes();

    PurchaseType getPurchaseType(long id);

    void addPurchaseType(PurchaseType purchaseType);

    void updatePurchaseType(PurchaseType purchaseType);

    void deletePurchaseType(long id);
}