package ru.isands.test.estore.service;

import org.springframework.data.domain.Page;
import ru.isands.test.estore.dao.entity.ElectroItem;

import java.util.List;

public interface ElectroItemService {

    Page<ElectroItem> getElectroItems(int page, int size);

    List<ElectroItem> getElectroItems();

    ElectroItem getElectroItem(long id);

    void addElectroItem(ElectroItem electroItem);

    void updateElectroItem(ElectroItem electroItem);

    void deleteElectroItem(long id);
}