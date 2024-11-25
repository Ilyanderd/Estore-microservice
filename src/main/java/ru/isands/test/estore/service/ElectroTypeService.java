package ru.isands.test.estore.service;

import ru.isands.test.estore.dao.entity.ElectroType;

import java.util.List;

public interface ElectroTypeService {
    List<ElectroType> getElectroTypes();

    ElectroType getElectroType(long id);

    void addElectroType(ElectroType electroType);

    void updateElectroType(ElectroType electroType);

    void deleteElectroType(long id);
}
