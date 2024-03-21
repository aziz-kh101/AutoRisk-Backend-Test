package com.autorisk.vmapi.dto.machine;

import com.autorisk.vmapi.custom.validation.OptionalNotBlank;

import lombok.Getter;

@Getter
public class MachineUpdateDto {

    @OptionalNotBlank
    private String ipAddress;
    @OptionalNotBlank
    private String hostname;
    @OptionalNotBlank
    private String os;
    @OptionalNotBlank
    private String cpu;
    @OptionalNotBlank
    private String memory;
    @OptionalNotBlank
    private String disk;
}