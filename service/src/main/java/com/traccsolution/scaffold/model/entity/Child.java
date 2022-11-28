package com.traccsolution.scaffold.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author KeeshanReddy
 * On Lombok :
 * Do not use @Data -  causes hibernate performance issues
 * Use @Builder cautiously - MapStruct @AfterMapping method call is not always generated in Mapping implementation class
 */

@Entity
@Table(name = "CHILD", schema = "SCAFFOLD")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter
@Setter
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( foreignKey = @ForeignKey(name="PARENT_ID_FK"), nullable = false)
    private Parent parent;

    @Column(name = "ACTION_ID", nullable = false)
    private UUID actionId;

    @Column(name = "TRACC_ID", nullable = false)
    private UUID traccId;

    @Column(name = "STAGE_ID", nullable = false)
    private UUID stageId;

    @Column(name = "DISPLAY_ORDER", nullable = false)
    private int displayOrder = 0;
}
