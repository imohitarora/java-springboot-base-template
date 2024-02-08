package com.neweltechnologies.portfolio.base;

import java.beans.FeatureDescriptor;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

public abstract class BaseService<ID extends Serializable, E extends BaseEntity, D extends BaseDTO<ID>> {

    @Autowired
    private BaseRepository<E, ID> repository;

    public List<D> findAll() {
        List<E> entities = repository.findAll();
        return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Page<D> findAll(Pageable pageable) {
        Page<E> page = repository.findAll(pageable);
        return page.map(this::mapToDTO);
    }

    public Optional<D> findById(ID id) {
        return repository.findById(id).map(this::mapToDTO);
    }

    public D save(D dto) {
        E entity = mapToEntity(dto);
        return mapToDTO(repository.save(entity));
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Transactional
    public D update(ID id, D dto) {
        // Retrieve the existing entity from the database
        Optional<E> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            E existingEntity = optionalEntity.get();
            // Copy properties from the provided DTO to the existing entity
            BeanUtils.copyProperties(dto, existingEntity, getNullPropertyNames(dto));
            return mapToDTO(repository.save(existingEntity));
        } else {
            throw new EntityNotFoundException("Entity with id " + id + " not found.");
        }
    }

    // Convert entity to DTO
    protected abstract D mapToDTO(E entity);

    // Convert DTO to entity
    protected abstract E mapToEntity(D dto);

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        return Stream.of(src.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> src.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }
}
