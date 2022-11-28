package com.traccsolution.scaffold.mapper.parent;

import com.traccsolution.scaffold.dto.parent.ParentRequestDTO;
import com.traccsolution.scaffold.dto.parent.ParentResponseDTO;
import com.traccsolution.scaffold.model.entity.Parent;
import org.mapstruct.*;

import java.util.List;

/**
 * @author KeeshanReddy
 */
@Mapper(componentModel = "spring")
public abstract class ParentMapper {


    @AfterMapping
    protected Parent updateChildsParent(@MappingTarget Parent entity) {
        entity.getChildren().forEach(e -> e.setParent(entity));
        return entity;
    }

    public abstract ParentRequestDTO toParentRequestDTOList(Parent entity);

    public abstract ParentResponseDTO toParentResponseDTO(Parent entity);

    public abstract Parent toParentEntityList(ParentRequestDTO dto);

    public abstract List<Parent> toParentEntityList(List<ParentRequestDTO> dto);

    public abstract List<ParentRequestDTO> toParentRequestDTOList(List<Parent> entity);
}
