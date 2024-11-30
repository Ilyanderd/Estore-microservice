package ru.isands.test.estore.dao.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;
import ru.isands.test.estore.dao.entity.ElectroItem;

public interface ElectroItemRepository extends JpaRepository<ElectroItem, Long> {

    Page<ElectroItem> findAll(Pageable pageable);
}