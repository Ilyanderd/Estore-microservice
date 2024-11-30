package ru.isands.test.estore.dao.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.isands.test.estore.dao.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    Page<Shop> findAll(Pageable pageable);
}