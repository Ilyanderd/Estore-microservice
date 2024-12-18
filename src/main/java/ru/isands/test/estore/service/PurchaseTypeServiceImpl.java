package ru.isands.test.estore.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dao.entity.PurchaseType;
import ru.isands.test.estore.dao.repo.PurchaseTypeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseTypeServiceImpl implements PurchaseTypeService {

    private PurchaseTypeRepository repository;

    @Override
    public Page<PurchaseType> getPurchaseTypes(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable);
    }

    @Override
    public List<PurchaseType> getPurchaseTypes() {
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