package ru.isands.test.estore.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isands.test.estore.dao.entity.PositionType;
import ru.isands.test.estore.service.PositionTypeService;

import java.util.List;

@RestController
@Tag(name = "PositionType", description = "Сервис для выполнения операций над должностями")
@RequestMapping("/estore/api/positionType")
@AllArgsConstructor
public class PositionTypeController {

    private final PositionTypeService service;

    @GetMapping
    public ResponseEntity<?> getPositionTypes() {
        try {
            List<PositionType> positionTypes = service.getPositionTypes();

            return new ResponseEntity<>(positionTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPositionType(@PathVariable long id) {
        try {
            PositionType positionType = service.getPositionType(id);

            return new ResponseEntity<>(positionType, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addPositionType(@RequestBody PositionType positionType) {
        try {
            service.addPositionType(positionType);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<?> updatePositionType(@RequestBody PositionType positionType) {
        try {
            service.updatePositionType(positionType);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deletePositionType(@PathVariable long id) {
        try {
            service.deletePositionType(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
