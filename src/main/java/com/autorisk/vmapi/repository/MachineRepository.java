package com.autorisk.vmapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.autorisk.vmapi.model.Machine;

public interface MachineRepository extends JpaRepository<Machine, UUID> {
    @Query("""
            SELECT m
            FROM Machine m
            WHERE m.hostname LIKE %:search%
            OR m.os LIKE %:search%
            OR m.cpu LIKE %:search%
            OR m.memory LIKE %:search%
            OR m.disk LIKE %:search%
            OR m.ipAddress LIKE %:search%
            """)
    List<Machine> findByMultipleCriteria(String search);
}
