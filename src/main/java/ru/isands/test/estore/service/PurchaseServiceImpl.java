package ru.isands.test.estore.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dao.entity.Purchase;
import ru.isands.test.estore.dao.repo.PurchaseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository repository;

    @Override
    public Page<Purchase> getPurchases(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable);
    }

    @Override
    public List<Purchase> getPurchases() {
        return repository.findAll();
    }

    @Override
    public Purchase getPurchase(long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Purchase with id " + id + " does not exist");
        }

        return repository.findById(id).get();
    }

    @Override
    public void addPurchase(Purchase purchase) {
        if (repository.existsById(purchase.getId())) {
            throw new IllegalArgumentException("Purchase already exists");
        }

        repository.save(purchase);
    }

    @Override
    public void updatePurchase(Purchase purchase) {
        if (!repository.existsById(purchase.getId())) {
            throw new IllegalArgumentException("Purchase does not exist");
        }

        repository.save(purchase);
    }

    @Override
    public void deletePurchase(long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Purchase does not exist");
        }

        repository.deleteById(id);
    }
}