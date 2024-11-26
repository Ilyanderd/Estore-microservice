package ru.isands.test.estore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dao.entity.ElectroType;
import ru.isands.test.estore.dao.repo.ElectroTypeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ElectroTypeServiceImpl implements ElectroTypeService {

    private final ElectroTypeRepository repository;

    @Override
    public List<ElectroType> getElectroTypes() {
        if (repository.findAll().isEmpty()) {
            throw new RuntimeException("List of electroTypes is empty");
        }

        return repository.findAll();
    }

    @Override
    public ElectroType getElectroType(long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("ElectroType with id " + id + " does not exist");
        }

        return repository.findById(id).get();
    }

    @Override
    public void addElectroType(ElectroType electroType) {
        if (repository.existsById(electroType.getId())) {
            throw new IllegalArgumentException("ElectroType already exists");
        }

        repository.save(electroType);
    }

    @Override
    public void updateElectroType(ElectroType electroType) {
        if (!repository.existsById(electroType.getId())) {
            throw new IllegalArgumentException("ElectroType does not exist");
        }

        repository.save(electroType);
    }

    @Override
    public void deleteElectroType(long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("ElectroType does not exist");
        }

        repository.deleteById(id);
    }
}