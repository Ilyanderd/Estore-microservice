package ru.isands.test.estore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dao.entity.PositionType;
import ru.isands.test.estore.dao.repo.PositionTypeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PositionTypeImpl implements PositionTypeService {

    private final PositionTypeRepository repository;

    @Override
    public List<PositionType> getPositionTypes() {
        if (repository.findAll().isEmpty()) {
            throw new IllegalArgumentException("List of PositionTypes is empty");
        }

        return repository.findAll();
    }

    @Override
    public PositionType getPositionType(long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("PositionType with id " + id + " does not exist");
        }

        return repository.findById(id).get();
    }

    @Override
    public void addPositionType(PositionType positionType) {
        if (repository.existsById(positionType.getId())) {
            throw new IllegalArgumentException("PositionType already exists");
        }

        repository.save(positionType);
    }

    @Override
    public void updatePositionType(PositionType positionType) {
        if (!repository.existsById(positionType.getId())) {
            throw new IllegalArgumentException("PositionType does not exist");
        }

        repository.save(positionType);
    }

    @Override
    public void deletePositionType(long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("PositionType does not exist");
        }

        repository.deleteById(id);
    }
}
