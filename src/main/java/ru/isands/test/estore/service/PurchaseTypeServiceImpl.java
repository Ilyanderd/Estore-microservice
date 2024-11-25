package ru.isands.test.estore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dao.entity.PurchaseType;
import ru.isands.test.estore.dao.repo.PurchaseTypeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseTypeServiceImpl implements PurchaseTypeService {

    private PurchaseTypeRepository repository;

    @Override
    public List<PurchaseType> getPurchaseTypes() {
        if (repository.findAll().isEmpty()) {
            throw new IllegalArgumentException("List of PurchaseTypes is empty");
        }

        return repository.findAll();
    }

    @Override
    public PurchaseType getPurchaseType(long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("PurchaseType with id " + id + " does not exist");
        }

        return repository.findById(id).get();
    }

    @Override
    public void addPurchaseType(PurchaseType purchaseType) {
        if (repository.existsById(purchaseType.getId())) {
            throw new IllegalArgumentException("PurchaseType already exists");
        }

        repository.save(purchaseType);
    }

    @Override
    public void updatePurchaseType(PurchaseType purchaseType) {
        if (!repository.existsById(purchaseType.getId())) {
            throw new IllegalArgumentException("PurchaseType does not exist");
        }

        repository.save(purchaseType);
    }

    @Override
    public void deletePurchaseType(long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("PurchaseType does not exist");
        }

        repository.deleteById(id);
    }
}
