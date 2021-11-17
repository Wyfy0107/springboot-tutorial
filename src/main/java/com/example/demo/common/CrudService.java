package com.example.demo.common;

import com.example.demo.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class CrudService<T extends BaseEntity> {
    private final JpaRepository<T, Long> repository;

    public CrudService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T create(T dto) {
        return repository.save(dto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public T update(Long id, T dto) {
        boolean existing = repository.existsById(id);

        if (!existing) {
            throw new NotFoundException();
        }

        Optional<T> entityToUpdate = repository.findById(id);
        dto.setId(id);

        return repository.save(dto);
    }

    public T getOne(Long id) {
        T foundEntity = repository.findById(id).orElse(null);

        if (foundEntity == null) {
            throw new NotFoundException("Student not found");
        }

        return foundEntity;
    }
}
