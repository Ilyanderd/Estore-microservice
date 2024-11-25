package ru.isands.test.estore.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isands.test.estore.dao.entity.Purchase;
import ru.isands.test.estore.service.PurchaseService;

import java.util.List;

@RestController
@Tag(name = "Purchase", description = "Сервис для выполнения операций над покупками")
@RequestMapping("/estore/api/purchase")
@AllArgsConstructor
public class PurchaseController {

    private final PurchaseService service;

    @GetMapping
    public ResponseEntity<?> getPurchases() {
        try {
            List<Purchase> purchases = service.getPurchases();

            return new ResponseEntity<>(purchases, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchase(@PathVariable long id) {
        try {
            Purchase purchase = service.getPurchase(id);

            return new ResponseEntity<>(purchase, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addPurchase(@RequestBody Purchase purchase) {
        try {
            service.addPurchase(purchase);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<?> updatePurchase(@RequestBody Purchase purchase) {
        try {
            service.updatePurchase(purchase);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePurchase(@PathVariable long id) {
        try {
            service.deletePurchase(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
