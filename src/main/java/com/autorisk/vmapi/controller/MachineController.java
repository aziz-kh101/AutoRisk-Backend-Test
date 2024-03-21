package com.autorisk.vmapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autorisk.vmapi.dto.machine.MachineAddDto;
import com.autorisk.vmapi.dto.machine.MachineUpdateDto;
import com.autorisk.vmapi.model.Machine;
import com.autorisk.vmapi.model.User;
import com.autorisk.vmapi.service.MachineService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Machines", description = "The Api for Cloud Machines")
@RestController
@RequestMapping("/machines")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class MachineController {

    private final MachineService machineService;

    @GetMapping("")
    public ResponseEntity<List<Machine>> getAll(@RequestParam(required = false) String search) {
        if (search != null)
            return ResponseEntity.ok(machineService.findByMultipleCriteria(search));
        return ResponseEntity.ok(machineService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<Machine> addMachine(@Valid @RequestBody MachineAddDto machineAddDto,
            Authentication authentication) {
        Machine machine = new Machine();
        machine.setIpAddress(machineAddDto.getIpAddress());
        machine.setHostname(machineAddDto.getHostname());
        machine.setOs(machineAddDto.getOs());
        machine.setCpu(machineAddDto.getCpu());
        machine.setMemory(machineAddDto.getMemory());
        machine.setDisk(machineAddDto.getDisk());
        machine.setOwner((User) authentication.getPrincipal());
        return ResponseEntity.ok(machineService.saveMachine(machine));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Machine> updateMachine(@PathVariable UUID id,
            @Valid @RequestBody MachineUpdateDto machineUpdateDto) {
        Machine machine = new Machine();
        machine.setIpAddress(machineUpdateDto.getIpAddress());
        machine.setHostname(machineUpdateDto.getHostname());
        machine.setOs(machineUpdateDto.getOs());
        machine.setCpu(machineUpdateDto.getCpu());
        machine.setMemory(machineUpdateDto.getMemory());
        machine.setDisk(machineUpdateDto.getDisk());
        return ResponseEntity.ok(machineService.updateMachine(id, machine));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateMachine(@PathVariable UUID id) {
        machineService.deleteMachine(id);
        return ResponseEntity.ok().body("deleted successfully");
    }

}
