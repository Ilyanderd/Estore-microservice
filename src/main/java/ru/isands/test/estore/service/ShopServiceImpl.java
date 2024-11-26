package ru.isands.test.estore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dao.entity.Shop;
import ru.isands.test.estore.dao.repo.ShopRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository repository;

    @Override
    public List<Shop> getShops() {
        if (repository.findAll().isEmpty()) {
            throw new IllegalArgumentException("List of Shops is empty");
        }

        return repository.findAll();
    }

    @Override
    public Shop getShop(long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Shop with id " + id + " does not exist");
        }

        return repository.findById(id).get();
    }

    @Override
    public void addShop(Shop shop) {
        if (repository.existsById(shop.getId())) {
            throw new IllegalArgumentException("Shop already exists");
        }

        repository.save(shop);
    }

    @Override
    public void updateShop(Shop shop) {
        if (!repository.existsById(shop.getId())) {
            throw new IllegalArgumentException("Shop does not exist");
        }

        repository.save(shop);
    }

    @Override
    public void deleteShop(long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Shop does not exist");
        }

        repository.deleteById(id);
    }
}