package com.traccsolution.scaffold.dto.parent;

import com.traccsolution.scaffold.dto.child.ChildResponseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * @author KeeshanReddy
 */
@Data
@NoArgsConstructor
public class ParentResponseDTO {

    @NotNull
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private UUID organisationId;
    @NotNull
    private List<ChildResponseDTO> children;

}
