package com.traccsolution.scaffold.dto.child;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author KeeshanReddy
 */
@Data
public class ChildResponseDTO {

    @NotNull
    private UUID id;
    @NotNull
    private UUID traccId;
    @NotNull
    private UUID stageId;
    @NotNull
    private UUID actionId;
    private Integer displayOrder = 0;

}

