package ru.isands.test.estore.service;

import org.springframework.data.domain.Page;
import ru.isands.test.estore.dao.entity.PositionType;

import java.util.List;

public interface PositionTypeService {

    Page<PositionType> getPositionTypes(int page, int size);

    List<PositionType> getPositionTypes();

    PositionType getPositionType(long id);

    void addPositionType(PositionType positionType);

    void updatePositionType(PositionType positionType);

    void deletePositionType(long id);
}