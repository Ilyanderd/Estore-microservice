package ru.isands.test.estore.service;

import ru.isands.test.estore.dao.entity.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getShops();

    Shop getShop(long id);

    void addShop(Shop shop);

    void updateShop(Shop shop);

    void deleteShop(long id);
}