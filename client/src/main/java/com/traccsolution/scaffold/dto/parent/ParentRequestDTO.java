package com.traccsolution.scaffold.dto.parent;

import com.traccsolution.scaffold.dto.child.ChildRequestDTO;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * @author KeeshanReddy
 */
@Data
@Builder
public class ParentRequestDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String description;

    @NotNull
    private UUID organisationId;

    @Singular
    @NotEmpty
    private List<@Valid ChildRequestDTO> children;

}
