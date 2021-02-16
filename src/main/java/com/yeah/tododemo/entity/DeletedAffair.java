package com.yeah.tododemo.entity;

import liquibase.pro.packaged.C;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "deleted_affairs")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DeletedAffair {
    @Id
    @Column(name = "affair_id")
    @EqualsAndHashCode.Include
    private UUID id;
    @Column(name = "description")
    private String affairDescription;
    @Column(name="priority")
    private int affairPriority;
}
