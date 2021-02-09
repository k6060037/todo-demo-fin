package com.yeah.tododemo.repository;

import com.yeah.tododemo.entity.DeletedAffair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeletedAffairRepository extends JpaRepository<DeletedAffair, UUID> {

}
