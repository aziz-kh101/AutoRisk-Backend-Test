package com.autorisk.vmapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.autorisk.vmapi.model.Machine;
import com.autorisk.vmapi.repository.MachineRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MachineServiceImpl implements MachineService {

    private final MachineRepository machineRepository;

    @Override
    public Machine saveMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    @Override
    public Machine findById(UUID id) {
        return machineRepository.findById(id).orElseThrow(() -> new RuntimeException("Machine not found"));
    }

    @Override
    public void deleteMachine(UUID id) {
        machineRepository.deleteById(id);
    }

    @Override
    public List<Machine> findAll() {
        return machineRepository.findAll();
    }

    @Override
    public Machine updateMachine(UUID id, Machine machine) {
        Machine m = machineRepository.findById(id).orElseThrow(() -> new RuntimeException("Machine not found"));
        var fields = machine.getClass().getDeclaredFields();
        for (var field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(machine) != null) {
                    field.set(m, field.get(machine));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return machineRepository.save(m);
    }

    @Override
    public List<Machine> findByMultipleCriteria(String search) {
        return machineRepository.findByMultipleCriteria(search);
    }

}
