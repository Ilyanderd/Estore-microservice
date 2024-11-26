package ru.isands.test.estore.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isands.test.estore.dao.entity.Shop;
import ru.isands.test.estore.service.ShopService;

import java.util.List;

@RestController
@Tag(name = "Shop", description = "Сервис для выполнения операций над магазинами")
@RequestMapping("/estore/api/shop")
@AllArgsConstructor
public class ShopController {

    private final ShopService service;

    @GetMapping
    public ResponseEntity<?> getShops() {
        try {
            List<Shop> shops = service.getShops();

            return new ResponseEntity<>(shops, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShop(@PathVariable long id) {
        try {
            Shop shops = service.getShop(id);

            return new ResponseEntity<>(shops, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addShop(@RequestBody Shop shop) {
        try {
            service.addShop(shop);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateShop(@RequestBody Shop shop) {
        try {
            service.updateShop(shop);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShop(@PathVariable long id) {
        try {
            service.deleteShop(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}