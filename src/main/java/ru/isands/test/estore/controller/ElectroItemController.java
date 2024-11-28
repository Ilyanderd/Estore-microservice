package ru.isands.test.estore.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isands.test.estore.dao.entity.ElectroItem;
import ru.isands.test.estore.service.ElectroItemService;

import java.util.List;

@RestController
@Tag(name = "ElectroItem", description = "Сервис для выполнения операций над товарами")
@RequestMapping("/estore/api/electroItem")
@AllArgsConstructor
public class ElectroItemController {

    private final ElectroItemService service;

    @GetMapping
    public ResponseEntity<?> getElectroItems() {
        try {
            List<ElectroItem> electroItems = service.getElectroItems();

            return new ResponseEntity<>(electroItems, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getElectroItem(@PathVariable long id) {
        try {
            ElectroItem electroItem = service.getElectroItem(id);

            return new ResponseEntity<>(electroItem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addElectroItem(@RequestBody ElectroItem electroItem) {
        try {
            service.addElectroItem(electroItem);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateElectroItem(@RequestBody ElectroItem electroItem) {
        try {
            service.updateElectroItem(electroItem);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteElectroItem(@PathVariable long id) {
        try {
            service.deleteElectroItem(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}