package ru.isands.test.estore.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dao.entity.ElectroItem;
import ru.isands.test.estore.dao.repo.ElectroItemRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ElectroItemServiceImpl implements ElectroItemService {

    private final ElectroItemRepository repository;

    @Override
    public Page<ElectroItem> getElectroItems(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable);
    }

    @Override
    public List<ElectroItem> getElectroItems() {
        return repository.findAll();
    }

    @Override
    public ElectroItem getElectroItem(long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("ElectroItem with id " + id + " does not exist");
        }

        return repository.findById(id).get();
    }

    @Override
    public void addElectroItem(ElectroItem electroItem) {
        if (repository.existsById(electroItem.getId())) {
            throw new IllegalArgumentException("ElectroItem already exists");
        }

        repository.save(electroItem);
    }

    @Override
    public void updateElectroItem(ElectroItem electroItem) {
        if (!repository.existsById(electroItem.getId())) {
            throw new IllegalArgumentException("ElectroItem does not exist");
        }

        repository.save(electroItem);
    }

    @Override
    public void deleteElectroItem(long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("ElectroItem does not exist");
        }

        repository.deleteById(id);
    }
}