package com.neweltechnologies.portfolio.base;

import java.util.List;
import java.util.Optional;

public interface IBaseService<DTO extends BaseDTO> {
    DTO create(DTO dto);

    DTO update(Long id, DTO dto);

    void delete(Long id);

    Optional<DTO> getById(Long id);

    List<DTO> getAll();
}