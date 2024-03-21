package com.autorisk.vmapi.service;

import java.util.List;
import java.util.UUID;

import com.autorisk.vmapi.model.Machine;

public interface MachineService {
    public Machine saveMachine(Machine machine);

    public Machine findById(UUID id);

    public void deleteMachine(UUID id);

    public List<Machine> findAll();

    public List<Machine> findByMultipleCriteria(String search);

    public Machine updateMachine(UUID id, Machine machine);
}
