package com.traccsolution.scaffold.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author KeeshanReddy
 * same class used to represent domain and entity model
 * On Lombok :
 * Do not use @Data -  causes hibernate performance issues
 * Use @Builder cautiously - MapStruct @AfterMapping method call is not always generated in Mapping implementation class
 */
@Entity
@Table(name = "PARENT", schema = "SCAFFOLD")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter
@Setter
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "NAME", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "DESCRIPTION", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "ORGANISATION_ID", nullable = false)
    private UUID organisationId;


    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Child> children = new ArrayList<>();
}
