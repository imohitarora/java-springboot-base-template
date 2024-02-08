package com.neweltechnologies.portfolio.base;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseController<DTO extends BaseDTO> {

    protected abstract IBaseService<DTO> getService();

    @PostMapping
    public ResponseEntity<DTO> create(@RequestBody DTO dto) {
        DTO createdDTO = getService().create(dto);
        return new ResponseEntity<>(createdDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> update(@PathVariable("id") Long id, @RequestBody DTO dto) {
        DTO updatedDTO = getService().update(id, dto);
        return new ResponseEntity<>(updatedDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        getService().delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> getById(@PathVariable("id") Long id) {
        return getService().getById(id)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DTO>> getAll() {
        List<DTO> allDTOs = getService().getAll();
        return new ResponseEntity<>(allDTOs, HttpStatus.OK);
    }
}
