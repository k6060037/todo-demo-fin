package com.yeah.tododemo.repository;

import com.yeah.tododemo.entity.DelAffair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DelAffairRepository extends JpaRepository<DelAffair, UUID> {

}
