package com.autorisk.vmapi.dto.machine;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class MachineAddDto {
    @NotBlank
    private String ipAddress;
    @NotBlank
    private String hostname;
    @NotBlank
    private String os;
    @NotBlank
    private String cpu;
    @NotBlank
    private String memory;
    @NotBlank
    private String disk;
}
