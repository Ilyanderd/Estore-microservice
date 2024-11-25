package ru.isands.test.estore.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isands.test.estore.dao.entity.PurchaseType;
import ru.isands.test.estore.service.PurchaseTypeService;

import java.util.List;

@RestController
@Tag(name = "PurchaseType", description = "Сервис для выполнения операций над типами покупок")
@RequestMapping("/estore/api/purchaseType")
@AllArgsConstructor
public class PurchaseTypeController {

    private final PurchaseTypeService service;

    @GetMapping
    public ResponseEntity<?> getPurchaseTypes() {
        try {
            List<PurchaseType> purchaseType = service.getPurchaseTypes();

            return new ResponseEntity<>(purchaseType, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchaseType(@PathVariable long id) {
        try {
            PurchaseType purchaseType = service.getPurchaseType(id);

            return new ResponseEntity<>(purchaseType, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addPurchaseType(@RequestBody PurchaseType purchaseType) {
        try {
            service.addPurchaseType(purchaseType);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<?> updatePurchaseType(@RequestBody PurchaseType purchaseType) {
        try {
            service.updatePurchaseType(purchaseType);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePurchaseType(@PathVariable long id) {
        try {
            service.deletePurchaseType(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
