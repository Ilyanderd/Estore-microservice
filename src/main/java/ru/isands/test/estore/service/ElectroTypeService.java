package ru.isands.test.estore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.isands.test.estore.dao.entity.ElectroType;

import java.util.List;

public interface ElectroTypeService {

    Page<ElectroType> getElectroTypes(int page, int size);

    List<ElectroType> getElectroTypes();

    ElectroType getElectroType(long id);

    void addElectroType(ElectroType electroType);

    void updateElectroType(ElectroType electroType);

    void deleteElectroType(long id);
}