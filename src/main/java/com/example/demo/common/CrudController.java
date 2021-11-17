package com.example.demo.common;

import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class CrudController<T extends BaseEntity> {
    private final CrudService<T> crudService;

    @Autowired
    public CrudController(CrudService<T> crudService) {
        this.crudService = crudService;
    }


    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        return ResponseEntity.ok(crudService.getAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<T> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(crudService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<T> create(@Valid @RequestBody T dto) {
        return new ResponseEntity<>(crudService.create(dto),
                HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity.HeadersBuilder<?> delete(@PathVariable Long id) {
        crudService.delete(id);
        return ResponseEntity.noContent();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<T> update(@PathVariable Long id,
                                    @RequestBody T dto) {
        return ResponseEntity.ok(crudService.update(id, dto));
    }
}
