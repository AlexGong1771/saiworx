package com.example.saiworx.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = ComponentTypeDeserializer.class)
public enum ComponentType {
    GEAR, COIL, SPRING, INVALID;
}
