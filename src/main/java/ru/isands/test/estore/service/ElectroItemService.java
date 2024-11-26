package ru.isands.test.estore.service;

import ru.isands.test.estore.dao.entity.ElectroItem;

import java.util.List;

public interface ElectroItemService {

    List<ElectroItem> getElectroItems();

    ElectroItem getElectroItem(long id);

    void addElectroItem(ElectroItem electroItem);

    void updateElectroItem(ElectroItem electroItem);

    void deleteElectroItem(long id);
}