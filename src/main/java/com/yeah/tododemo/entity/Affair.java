package com.yeah.tododemo.entity;

import liquibase.pro.packaged.C;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "affairs")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Affair {
    @Id
    @Column(name = "affair_id")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @EqualsAndHashCode.Include
    private UUID id;
    @Column(name = "affair_description")
    private String affairDescription;
    @Column(name="affair_priority")
    private int affairPriority;
}
