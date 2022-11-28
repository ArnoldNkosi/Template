package com.traccsolution.scaffold.service;

import com.traccsolution.scaffold.exception.RestResourceNotFoundException;
import com.traccsolution.scaffold.model.entity.Parent;
import com.traccsolution.scaffold.model.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


/**
 * @author KeeshanReddy
 */
@Service
@Transactional(rollbackFor = {Exception.class, Error.class})
public class ParentService {

    private ParentRepository parentRepository;

    public Parent createParent(Parent parent){
        return parentRepository.save(parent);
    }

    public Parent findById(UUID id) throws RestResourceNotFoundException {
        Optional<Parent> parent = parentRepository.findById(id);
        return parent.orElseThrow(() -> createResourceNotFoundException(id));
    }


    private RestResourceNotFoundException createResourceNotFoundException(UUID id) {
        // if resource was not found, the message would be returned via ERROR DTO
        // "Rest Resources not found. resource name = parent. Search criteria = {parent id=1004e304-cafa-4a56-870e-97ad672e0714}"
        // for scenarios where more than one filter criteria was used to fetch,
        // you may add as many filters to the error message as needed
        return RestResourceNotFoundException.builder()
                .resourceName("parent")
                .filter("parent id", id.toString())
                .build();
    }

    @Autowired
    public void setParentRepository(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }
}
