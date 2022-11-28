package com.traccsolution.scaffold.controller;

import com.traccsolution.scaffold.dto.parent.ParentRequestDTO;
import com.traccsolution.scaffold.dto.parent.ParentResponseDTO;
import com.traccsolution.scaffold.exception.RestResourceNotFoundException;
import com.traccsolution.scaffold.mapper.parent.ParentMapper;
import com.traccsolution.scaffold.model.entity.Parent;
import com.traccsolution.scaffold.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @author KeeshanReddy
 */
@RestController
@RequestMapping("/parent")
public class ParentController {

    private ParentService parentService;
    private ParentMapper parentMapper;


    @PostMapping
    public ResponseEntity<ParentResponseDTO> createParent(@Valid @RequestBody ParentRequestDTO dto) {
        Parent parent = parentMapper.toParentEntityList(dto);
        parent = parentService.createParent(parent);
        ParentResponseDTO responseDTO = parentMapper.toParentResponseDTO(parent);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParentResponseDTO> getParentById(@PathVariable UUID id) throws RestResourceNotFoundException {
        Parent parent = parentService.findById(id);
        ParentResponseDTO parentResponseDTO = parentMapper.toParentResponseDTO(parent);
        return new ResponseEntity<>(parentResponseDTO, HttpStatus.OK);
    }

    @Autowired
    public void setParentMapper(ParentMapper parentMapper) {
        this.parentMapper = parentMapper;
    }

    @Autowired
    public void setParentService(ParentService parentService) {
        this.parentService = parentService;
    }
}
