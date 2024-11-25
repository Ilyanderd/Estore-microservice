package ru.isands.test.estore.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isands.test.estore.dao.entity.ElectroType;
import ru.isands.test.estore.service.ElectroTypeService;

import java.util.List;

@RestController
@Tag(name = "ElectroType", description = "Сервис для выполнения операций над типами электроники")
@RequestMapping("/estore/api/electroType")
@AllArgsConstructor
public class ElectroTypeController {

    private final ElectroTypeService service;

    @GetMapping
    public ResponseEntity<?> getElectroTypes() {
        try {
            List<ElectroType> electroTypes = service.getElectroTypes();

            return new ResponseEntity<>(electroTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getElectroType(@PathVariable("id") long id) {
        try {
            ElectroType electroType = service.getElectroType(id);

            return new ResponseEntity<>(electroType, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addElectroType(@RequestBody ElectroType electroType) {
        try {
            service.addElectroType(electroType);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateElectroType(@RequestBody ElectroType electroType) {
        try {
            service.updateElectroType(electroType);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteElectroType(@PathVariable("id") long id) {
        try {
            service.deleteElectroType(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
