package com.neweltechnologies.portfolio.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseController<ID extends Serializable, E extends BaseEntity, D extends BaseDTO<ID>> {

    protected final BaseService<ID, E, D> service;

    public BaseController(BaseService<ID, E, D> service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<D>> findAll() {
        List<D> entities = service.findAll();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<D>> findAll(Pageable pageable) {
        Page<D> entities = service.findAll(pageable);
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> findById(@PathVariable("id") ID id) {
        Optional<D> entity = service.findById(id);
        return entity.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<D> save(@RequestBody D entity) {
        D savedEntity = service.save(entity);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable("id") ID id, @RequestBody D entity) {
        Optional<D> existingEntity = service.findById(id);
        if (existingEntity.isPresent()) {
            // Update the existing entity with the new data
            D updatedEntity = service.update(id, entity);
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") ID id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
