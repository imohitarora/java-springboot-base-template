package com.aboutmohit.springbase.base;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseService<E extends BaseEntity, DTO extends BaseDTO> implements IBaseService<DTO> {

    protected abstract BaseRepository<E> getRepository();

    protected abstract DTO mapToDTO(E entity);

    protected abstract E mapToEntity(DTO dto);

    @Override
    public DTO create(DTO dto) {
        E entity = mapToEntity(dto);
        E savedEntity = getRepository().save(entity);
        return mapToDTO(savedEntity);
    }

    @Override
    public DTO update(Long id, DTO dto) {
        Optional<E> optionalEntity = getRepository().findById(id);
        if (optionalEntity.isPresent()) {
            E entity = optionalEntity.get();
            mapDtoToEntity(dto, entity);
            E savedEntity = getRepository().save(entity);
            return mapToDTO(savedEntity);
        } else {
            throw new RuntimeException("Entity not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public Optional<DTO> getById(Long id) {
        return getRepository().findById(id)
                .map(this::mapToDTO);
    }

    @Override
    public List<DTO> getAll() {
        return getRepository().findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    protected void mapDtoToEntity(DTO dto, E entity) {
        // Implement this method in subclass if needed
    }
}
