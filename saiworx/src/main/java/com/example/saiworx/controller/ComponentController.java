package com.example.saiworx.controller;

import com.example.saiworx.entity.Component;
import com.example.saiworx.service.ComponentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/components")
public class ComponentController {

    private final ComponentService service;

    public ComponentController(ComponentService service) {
        this.service = service;
    }

    @PutMapping
    public ResponseEntity<Component> createComponent(@RequestBody Component component) {
        Component savedComponent = service.createComponent(component);
        return new ResponseEntity<>(savedComponent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Component>> getAllComponents() {
        return ResponseEntity.ok(service.getAllComponents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Component> getComponentById(@PathVariable UUID id) {
        return service.getComponentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComponent(@PathVariable UUID id) {
        if (service.deleteComponent(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}