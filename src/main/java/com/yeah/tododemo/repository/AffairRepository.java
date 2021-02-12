package com.yeah.tododemo.repository;

import com.yeah.tododemo.entity.Affair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AffairRepository extends JpaRepository<Affair, UUID> {
    List<Affair> findByAffairPriorityGreaterThan(int priority);
}
