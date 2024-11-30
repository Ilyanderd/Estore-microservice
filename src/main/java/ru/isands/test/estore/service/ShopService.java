package ru.isands.test.estore.service;

import org.springframework.data.domain.Page;
import ru.isands.test.estore.dao.entity.Shop;

import java.util.List;

public interface ShopService {

    Page<Shop> getShops(int page, int size);

    List<Shop> getShops();

    Shop getShop(long id);

    void addShop(Shop shop);

    void updateShop(Shop shop);

    void deleteShop(long id);
}