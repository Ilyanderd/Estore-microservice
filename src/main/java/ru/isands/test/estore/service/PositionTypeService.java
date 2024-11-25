package ru.isands.test.estore.service;

import ru.isands.test.estore.dao.entity.PositionType;

import java.util.List;

public interface PositionTypeService {
    List<PositionType> getPositionTypes();
    PositionType getPositionType(long id);
    void addPositionType(PositionType positionType);
    void updatePositionType(PositionType positionType);
    void deletePositionType(long id);
}
