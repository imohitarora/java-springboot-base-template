package com.neweltechnologies.portfolio.base;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.beans.FeatureDescriptor;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class BaseService<T, ID extends Serializable> {

    @Autowired
    protected BaseRepository<T, ID> repository;

    public List<T> findAll() {
        return repository.findAll();
    }

    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Transactional
    public T update(ID id, T entity) {
        // Retrieve the existing entity from the database
        Optional<T> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            T existingEntity = optionalEntity.get();
            // Copy properties from the provided entity to the existing entity
            BeanUtils.copyProperties(entity, existingEntity, getNullPropertyNames(entity));
            return repository.save(existingEntity);
        } else {
            throw new EntityNotFoundException("Entity with id " + id + " not found.");
        }
    }

    // Helper method to get null property names for BeanUtils.copyProperties
    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        return Stream.of(src.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> src.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }
}
